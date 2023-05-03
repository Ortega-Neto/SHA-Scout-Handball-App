package br.com.lconeto.library.data.common

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import br.com.lconeto.library.data.database.SHADataBase
import org.junit.After
import org.junit.Before
import java.io.IOException

open class BaseDataBaseTest {
    protected lateinit var db: SHADataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            SHADataBase::class.java
        ).build()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}
