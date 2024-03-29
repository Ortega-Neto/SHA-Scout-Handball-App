import config.Config
import config.Dependencies
import config.TestDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
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
    // Plataform
    implementation(platform(Dependencies.Plataform.BOM))

    // Android
    implementation(Dependencies.Android.CORE)
    implementation(Dependencies.Android.APP_COMPAT)
    implementation(Dependencies.Android.MATERIAL)
    implementation(Dependencies.Android.CONSTRAINT_LAYOUT)
    implementation(Dependencies.Android.GSON)
    implementation(Dependencies.Lifecycle.LIVE_DATA)
    implementation(Dependencies.Lifecycle.EXTENSIONS)
    api(Dependencies.Android.VIEW_BINDING)
    api(Dependencies.Android.DATA_BINDING)
    api(Dependencies.Android.NAVIGATION)

    // Room
    implementation(Dependencies.RoomDataBase.ROOM)
    implementation(Dependencies.RoomDataBase.ROOM_RUNTME)
    annotationProcessor(Dependencies.RoomDataBase.ROOM_COMPILER)
    kapt(Dependencies.RoomDataBase.ROOM_COMPILER)

    // Sweet Alert Dialog
    api(Dependencies.SweetAlertDialog.SWEET_ALERT)

    // Masked Edit Text
    api(Dependencies.MaskEditText.MASKED_EDIT_TEXT)

    // Floating Action Button
    api(Dependencies.FloatingActionButton.FAB)

    testImplementation(TestDependencies.TestImplementation.JUNIT)
    androidTestImplementation(TestDependencies.AndroidTestImplementation.JUNIT)
    androidTestImplementation(TestDependencies.AndroidTestImplementation.ESPRESSO)
    androidTestImplementation(TestDependencies.AndroidTestImplementation.CORE)
    androidTestImplementation(TestDependencies.AndroidTestImplementation.CORE_KTX)
    androidTestImplementation(TestDependencies.AndroidTestImplementation.COROUTINES)
}
