# 按包过滤，保留类名称
-keep class com.opt.lib.reflection.**
# 按包过滤，保留全部类成员，类名不保留
-keepclassmembers class com.opt.lib.reflection.**{*;}

# 少用一劳永逸配置
# -keep class com.opt.lib.reflection.**{*;}

# 拉黑型配置
-keep class !com.z.optcode.**,**{*;}