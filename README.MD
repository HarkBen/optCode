# 混淆规则示范

Gradle plugin 3.4.0  之后 已 使用  R8 编译器协同工作，简单理解为 比proguard优化更好


### 四大组件，View 默认已忽略

### 关于：proguard-android-optimize.txt
>位于Android\Sdk\tools\proguard
>需要仔细阅读 其配置规则
主要需要注意的是：enum，R文件，native 均已配置


### 多module 工程的混淆配置

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
>lib中 使用


### 混淆规则1 keep型


### 混淆规则2