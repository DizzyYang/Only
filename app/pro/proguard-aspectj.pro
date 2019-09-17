#aspectj
-dontwarn org.aspectj.**
-keep class org.aspectj.** { *; }
-keepnames @org.aspectj.lang.annotation.Aspect class * {
    ajc* <methods>;
}
