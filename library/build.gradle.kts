import config.Config
import config.Dependencies
import config.TestDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "br.com.lconeto.library"
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation (Dependencies.Android.CORE)
    implementation (Dependencies.Android.APP_COMPAT)
    implementation (Dependencies.Android.MATERIAL)
    implementation (Dependencies.Android.CONSTRAINT_LAYOUT)

    testImplementation (TestDependencies.TestImplementation.JUNIT)
    androidTestImplementation (TestDependencies.AndroidTestImplementation.JUNIT)
    androidTestImplementation (TestDependencies.AndroidTestImplementation.ESPRESSO)
}