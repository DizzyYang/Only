# Only


  步骤1：添加jitpack库到你的根build.gradle

        allprojects {
            repositories {
                ...
                maven { url "https://jitpack.io" }
            }
        }

  步骤2：app的build.gradle添加依赖关系

        android {
            ...
            compileOptions {
                sourceCompatibility JavaVersion.VERSION_1_8
                targetCompatibility JavaVersion.VERSION_1_8
            }
        }

        dependencies {
            api 'com.github.DizzyYang:Only:2.3.0'
            annotationProcessor 'com.jakewharton:butterknife-compiler:9.0.0'
            annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'
        }
