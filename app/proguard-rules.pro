# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\IDE\SDKofAS/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

##========================================================================================
##===============Begin: proguard configuration common for all Android apps ===============

-optimizationpasses 5          # 指定代码的压缩级别
-dontusemixedcaseclassnames   # 是否使用大小写混合
-dontskipnonpubliclibraryclasses    #不去忽略非公共的库类
-dontpreverify           # 混淆时是否做预校验
-dontoptimize           #不优化输入的类文件
-verbose                # 混淆时是否记录日志
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*    # 混淆时所采用的算法
-keepattributes *Annotation*    #保护注解


    #忽略警告(避免生成的APK出现错误，不能打开)
    #-ignorewarning

# ------------------系统类不需要混淆START-------------------
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService
-keep public class * extends android.support.**
# ------------------系统类不需要混淆END---------------------


-keepclasseswithmembernames class * {  # 保持 native 方法不被混淆
    native <methods>;
}
-keepclasseswithmembers class * {   # 保持自定义控件类不被混淆
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {# 保持自定义控件类不被混淆
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * extends android.app.Activity { # 保持自定义控件类不被混淆
    public void *(android.view.View);
}
-keepclassmembers enum * {     # 保持枚举 enum 类不被混淆
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep class * implements android.os.Parcelable { # 保持 Parcelable 不被混淆
    public static final android.os.Parcelable$Creator *;
}
-keepclassmembers class * implements java.io.Serializable { # 保持 Serializable成员 不被混淆
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
##=============== End: proguard configuration common for all Android apps ===============
##========================================================================================


# ===================极光推送 START===================
-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
# Jpush v2.0.5 ~ v2.1.7 版本有引入 gson 和 protobuf ，增加排除混淆的配置。(2.1.8版本不需配置)
# -------- gson && protobuf --------
-dontwarn com.google.**
-keep class com.google.gson.** {*;}
-keep class com.google.protobuf.** {*;}
# ===================极光推送 END======================


# ===================OkHttp START===================
-dontwarn okio.**
-keep class okio.** {*;}
# ===================Okhttp END=====================


# ===================Gson START===================
-keepattributes Signature
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson 下面替换成自己的实体类
-keep class com.example.xm.zhoubianyouofour.dest.entity.**{ *; }
-keep class com.example.xm.zhoubianyouofour.find.entity.**{ *; }
-keep class com.example.xm.zhoubianyouofour.homepage.entity.**{ *; }
-keep class com.example.xm.zhoubianyouofour.mine.entity.**{ *; }
# ===================Gson END=====================

