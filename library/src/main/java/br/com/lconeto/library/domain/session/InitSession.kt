package br.com.lconeto.library.domain.session

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.lconeto.library.data.database.SHADataBase
import br.com.lconeto.library.data.session.AppSession
import br.com.lconeto.library.data.session.AppSession.Companion.SESSION

object InitSession {
    operator fun invoke(context: Context) {
        if(!SESSION.isInitialized) {
            SESSION = AppSession.Session(
                isInitialized = true,
                database = instanceDataBase(context)
            )
        }
    }

    private fun instanceDataBase(context: Context): RoomDatabase {
        return Room.databaseBuilder(
            context,
            SHADataBase::class.java,
            DATA_BASE_NAME
        ).build()
    }

    private const val DATA_BASE_NAME = "SHADataBase"
}
