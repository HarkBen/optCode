# 混淆规则示范

Gradle plugin 3.4.0  之后 已 使用  R8 编译器协同工作

就混淆工作而言，可以简单理解为 比proguard优化更好

同事根据官方文档，使用R8之后，不应该改动默认


### 四大组件，View 默认已忽略

### 关于：proguard-android-optimize.txt
>位于Android\Sdk\tools\proguard
>需要仔细阅读 其已经配置的规则
主要需要注意的是：
* enum
* R文件
* native
* Activity内的用xml的 onClick
* JavascriptInterface 注解修饰的函数

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

在 library module 下的 proguardFiles 并不会生效

每个library使用 consumer-rules更多的是为了
* 1.方便管理
* 2.独立发布与 静态依赖使用一个配置即可

最佳实践配置：
```groovy
 consumerProguardFiles  'proguard-rules.pro','proguard-android-optimize.pro'
```
proguard-android-optimize.pro 来自 proguard-android-optimize.txt



### 混淆规则1 开白型

以 -keep 关键字开头，默认全部混淆，除了被keep的类或成员



### 混淆规则2 拉黑型

