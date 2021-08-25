plugins {
    id(Plugins.APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.HILT_ANDROID_PLUGIN)
    id(Plugins.SAFE_ARGS)
    id(Plugins.PARCELIZE)
    id(Plugins.GMS_GOOGLE_SERVICES)
    id("kotlin-android")
}

android {
    compileSdk = DefaultConfig.COMPILE_SDK

    defaultConfig {
        applicationId = DefaultConfig.APPLICATION_ID
        minSdk = DefaultConfig.MIN_SDK
        targetSdk = DefaultConfig.TARGET_SDK
        buildToolsVersion = DefaultConfig.BUILD_TOOLS

        versionCode = DefaultConfig.VERSION_CODE
        versionName = DefaultConfig.VERSION_NAME

        testInstrumentationRunner = Test.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(AndroidX.CORE_KTX)
    implementation(AndroidX.APPCOMPAT)
    implementation(AndroidX.MATERIAL)
    implementation(AndroidX.CONSTRAINTLAYOUT)
    implementation(AndroidX.FRAGMENT_KTX)
    implementation(AndroidX.ACTIVITY_KTX)
    implementation(Kotlin.KOTLIN_STDLIBS)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation(Test.JUNIT)
    androidTestImplementation(Test.AndroidTest.JUNIT_EXT)
    androidTestImplementation(Test.AndroidTest.ESPRESSO_CORE)

    //Retrofit
    implementation(Square.RETROFIT)
    implementation(Square.CONVERTER_GSON)
    implementation(Square.ADAPTER_RXJAVA)
    implementation(Square.GSON)

    //OkHttp Logging Interceptor
    implementation(Square.OKHTTP_LOGGING_INTERCEPTOR)

    //Navigation
    implementation(AndroidX.Navigation.NAVIGATION_FRAGMENT_KTX)
    implementation(AndroidX.Navigation.NAVIAGATION_UI_KTX)

    //Lifecycle
    implementation(AndroidX.Lifecycle.VIEWMODEL)
    implementation(AndroidX.Lifecycle.LIVEDATA)

    // RxJava
    implementation(ReactiveX.RX_JAVA)
    implementation(ReactiveX.RX_ANDROID)

    //Hilt
    implementation(DaggerHilt.HILT_ANDROID)
    kapt(DaggerHilt.HILT_ANDROID_COMPILER)

    //Coil
    implementation(Coil.COIL)

    //Annotations
    implementation(Annotations.SUPPORT_ANNOTATIONS)

    //Crypto
    implementation(AndroidX.Crypto.CRYPTO)

    //Kakao Login
    //implementation group: project.kakao_sdk_group, name: 'usermgmt', version: project.kakao_sdk_version
    implementation(KakaoSDK.V2_USER)

    //Google Firebase
    implementation(platform(Firebase.FIREBASE_BOM))
    implementation(Firebase.FIREBASE_ANALYTICS_KTX)
    implementation(Firebase.FIREBASE_AUTH_KTX)
    implementation(Firebase.PLAY_SERVICE_AUTH)




}