package config

object TestDependencies {
    private object Versions {
        const val TEST_JUNIT = "4.13.2"
        const val ANDROID_TEST_JUNIT = "1.1.5"
        const val ESPRESSO = "3.5.1"
        const val CORE = "1.5.0"
    }

    object TestImplementation {
        const val JUNIT = "junit:junit:$${Versions.TEST_JUNIT}"
    }

    object AndroidTestImplementation {
        const val JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_TEST_JUNIT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
        const val CORE = "androidx.test:core:${Versions.CORE}"
        const val CORE_KTX = "androidx.test:core-ktx:${Versions.CORE}"
    }
}
