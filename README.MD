# 拒绝敷衍，安卓中的多模块的混淆规则

Gradle plugin3.4.0之后已使用R8编译器协同工作

就混淆工作而言，可以简单理解为比proguard优化更好

同时根据官方文档，使用R8之后，不应该改动默认配置，包括优化级别等信息

### 本项目中示范内容如下
* 一个宿主APP module
* 一个 library_module module
* 测试混淆开关
* 测试混淆规则传递
*

### 安卓项目中默认已忽略的内容
* 四大组件
* View
* JavascriptInterface 注解修饰的函数

### 关于：proguard-android-optimize.txt
>位于Android\Sdk\tools\proguard
需要仔细阅读 其已经配置的规则

主要需要注意的是：
* enum 类
* R文件
* native 就是JNI 相关
* Activity内的用xml的 onClick


### 静态依赖 lib>host  混淆开关测试
* 全部关闭混淆 ：不混淆

* lib 开启,host 关闭：全部不混淆

* lib 关闭,host 开启：全混淆
>注意data的toString中的字段名称，在编译阶段已经保留了
```java
   @NotNull
   public String toString() {
      return "AppInfo(name=" + this.name + ", versionName=" + this.versionName + ")";
   }
```

### 静态依赖 lib>host 如何单独配置混淆规则，使用 consumer-rules

consumerProguardFiles 配置的混淆将被传递合并给宿主APP module

在本次测试项目中，在library_module module 中配置忽略 app module的类
```log
-keep class **.**.AppInfo{*;}
```

相比较 在 library module 下的 proguardFiles 并不会生效

每个library使用 consumer-rules更多的是为了
* 1.方便管理
* 2.独立发布与 静态依赖使用一个配置即可

最佳实践配置：
```groovy
 consumerProguardFiles  'proguard-rules.pro','proguard-android-optimize.pro'
```
proguard-android-optimize.pro 来自 proguard-android-optimize.txt



### 混淆规则方式1 开白型

默认全混淆，对-keep 规则下的进行开白，不混淆

通常都是以此形式配置


### 混淆规则方式2 拉黑型 ：不建议在模块化跟组件化的项目中使用

* 通常拉黑型规则放在最后一行！！！！！，且不要放在 library module中 避免成为害群之马

对keep的逆向使用，默认保留全部类与成员，排除!条件下的不进行保留

示范：
```json
-keep class !com.z.optcode.**,**{*;}
```

当前项目中在

* app module下添加混淆 当前包下全部内容
```log
-keep class !com.z.optcode.**,**{*;}
```

* library_module 下添加混淆 当前包下全部内容
```log
-keep class !com.opt.library_module.**,**{*;}
```

* 结果
最终生效的是app 内配置的规则,library_module 下的类被混淆


