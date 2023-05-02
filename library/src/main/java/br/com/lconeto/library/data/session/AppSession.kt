package br.com.lconeto.library.data.session

import androidx.room.RoomDatabase

class AppSession {
    data class Session(
        var isInitialized: Boolean = false,
        val database: RoomDatabase
    )

    companion object {
        lateinit var SESSION: Session
    }
}
