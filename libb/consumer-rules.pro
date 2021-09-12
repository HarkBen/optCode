# 按包过滤，保留类名称
-keep class com.opt.libb.reflection.**
# 按包过滤，保留全部类成员，类名不保留
-keepclassmembers class com.opt.libb.reflection.**{*;}