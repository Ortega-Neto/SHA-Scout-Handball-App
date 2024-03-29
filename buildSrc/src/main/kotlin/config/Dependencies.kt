package config

object Dependencies {

    private object Versions {
        // Plataform
        const val BOM = "1.8.0"

        // Android
        const val ANDROID_CORE = "1.9.0"
        const val APP_COMPAT = "1.6.0"
        const val MATERIAL = "1.8.0"
        const val CONSTRAINT_LAYOUT = "2.1.4"
        const val GSON = "2.8.8"
        const val VIEW_BINDING = "8.0.1"
        const val DATA_BINDING = "8.0.1"
        const val NAVIGATION = "2.5.3"

        // LifeCycle
        const val LYFE_CYCLE = "2.6.1"
        const val LYFE_CYCLE_EXTENSIONS = "2.2.0"

        // ROOM
        const val ROOM = "2.5.1"

        // SweetAlertDialog
        const val SWEET_ALERT = "1.3"

        // MaskEditText
        const val MASKED_EDIT_TEXT = "4.0.7"

        // FloatingActionButton
        const val FAB = "1.10.1"
    }

    object Plataform {
        const val BOM = "org.jetbrains.kotlin:kotlin-bom:${Versions.BOM}"
    }

    object Android {
        const val CORE = "androidx.core:core-ktx:${Versions.ANDROID_CORE}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
        const val VIEW_BINDING = "androidx.databinding:viewbinding:${Versions.VIEW_BINDING}"
        const val DATA_BINDING = "androidx.databinding:databinding-runtime:${Versions.DATA_BINDING}"
        const val NAVIGATION = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    }

    object Lifecycle {
        const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LYFE_CYCLE}"
        const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LYFE_CYCLE}"
        const val EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LYFE_CYCLE_EXTENSIONS}"
    }

    object RoomDataBase {
        const val ROOM = "androidx.room:room-ktx:${Versions.ROOM}"
        const val ROOM_RUNTME = "androidx.room:room-runtime:${Versions.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
    }

    object SweetAlertDialog {
        const val SWEET_ALERT = "cn.pedant.sweetalert:library:${Versions.SWEET_ALERT}"
    }

    object MaskEditText {
        const val MASKED_EDIT_TEXT = "io.github.vicmikhailau:MaskedEditText:${Versions.MASKED_EDIT_TEXT}"
    }

    object FloatingActionButton {
        const val FAB = "com.getbase:floatingactionbutton:${Versions.FAB}"
    }
}
