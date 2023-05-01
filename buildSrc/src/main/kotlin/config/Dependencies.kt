package config

object Dependencies {

    private object Versions {
        const val ANDROID_CORE = "1.9.0"
        const val APP_COMPAT = "1.6.0"
        const val MATERIAL = "1.8.0"
        const val CONSTRAINT_LAYOUT = "2.1.4"
    }

    object Android {
        const val CORE = "androidx.core:core-ktx:${Versions.ANDROID_CORE}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    }
}
