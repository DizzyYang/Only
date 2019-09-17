# Only


  步骤1：添加插件和jitpack库到你的根build.gradle

        buildscript {
            dependencies {
                ...
                classpath 'com.jakewharton:butterknife-gradle-plugin:9.0.0'
                classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.4'
            }
        }

        allprojects {
            repositories {
                ...
                maven { url "https://jitpack.io" }
            }
        }

  步骤2：app的build.gradle添加依赖关系

        apply plugin: 'com.jakewharton.butterknife'
        apply plugin: 'com.hujiang.android-aspectjx'

        android {
            ...
            compileOptions {
                sourceCompatibility JavaVersion.VERSION_1_8
                targetCompatibility JavaVersion.VERSION_1_8
            }
        }

        dependencies {
            api 'com.github.DizzyYang:Only:2.3.6'
            annotationProcessor 'com.jakewharton:butterknife-compiler:9.0.0'
            annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'
        }
