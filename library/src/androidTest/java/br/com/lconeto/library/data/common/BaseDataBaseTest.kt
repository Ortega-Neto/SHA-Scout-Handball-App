package br.com.lconeto.library.data.common

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import br.com.lconeto.library.data.database.SHADataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import java.io.IOException

@ExperimentalCoroutinesApi
open class BaseDataBaseTest {
    protected lateinit var db: SHADataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            SHADataBase::class.java
        ).build()

        val testDispatcher = TestCoroutineDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
        Dispatchers.resetMain()
    }
}
