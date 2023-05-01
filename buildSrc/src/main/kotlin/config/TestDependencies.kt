package config

object TestDependencies {
    private object Versions {
        const val TEST_JUNIT = "4.13.2"
        const val ANDROID_TEST_JUNIT = "1.1.5"
        const val ESPRESSO = "4.13.2"
    }

    object TestImplementation {
        const val JUNIT = "junit:junit:$${Versions.TEST_JUNIT}"
    }

    object AndroidTestImplementation {
        const val JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_TEST_JUNIT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    }
}
