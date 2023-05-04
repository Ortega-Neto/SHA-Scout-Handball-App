import config.Dependencies
import config.TestDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "br.com.lconeto.newgame"
    compileSdk = config.Config.COMPILE_SDK

    defaultConfig {
        minSdk = config.Config.MIN_SDK
        targetSdk = config.Config.TARGET_SDK

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

    implementation(Dependencies.Android.CORE)
    implementation(Dependencies.Android.APP_COMPAT)
    implementation(Dependencies.Android.MATERIAL)
    implementation(Dependencies.Android.CONSTRAINT_LAYOUT)

    testImplementation(TestDependencies.TestImplementation.JUNIT)
    androidTestImplementation(TestDependencies.AndroidTestImplementation.JUNIT)
    androidTestImplementation(TestDependencies.AndroidTestImplementation.ESPRESSO)
}
