import config.Config
import config.Dependencies
import config.TestDependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "br.com.lconeto.sha"
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        applicationId = "br.com.lconeto.sha"
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(mapOf("path" to ":library")))
    implementation(project(mapOf("path" to ":new-game")))

    implementation(Dependencies.Android.CORE)
    implementation(Dependencies.Android.APP_COMPAT)
    implementation(Dependencies.Android.MATERIAL)
    implementation(Dependencies.Android.CONSTRAINT_LAYOUT)

    testImplementation(TestDependencies.TestImplementation.JUNIT)
    androidTestImplementation(TestDependencies.AndroidTestImplementation.JUNIT)
    androidTestImplementation(TestDependencies.AndroidTestImplementation.ESPRESSO)
}
