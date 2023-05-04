package br.com.lconeto.library.data.database.game

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.lconeto.library.data.common.BaseDataBaseTest
import br.com.lconeto.library.data.common.game
import br.com.lconeto.library.data.database.game.repository.GameRepositoryImpl
import br.com.lconeto.library.domain.helper.game.GameHelper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class GameRepositoryImplTest : BaseDataBaseTest() {

    private lateinit var gameRepositoryImpl: GameRepositoryImpl

    @Before
    fun setup() {
        gameRepositoryImpl = GameRepositoryImpl(
            gameDao = db.gameDao(),
            gameHelper = GameHelper()
        )
    }

    @Test
    @Throws(Exception::class)
    fun givenGame_shouldInsertGameAtDatabase() = runTest {
        gameRepositoryImpl.insertGame(game)

        // ADICIONAR O COROUTINES TESTE
        val gameById = gameRepositoryImpl.getGameById(game.id)

        assertThat(gameById, equalTo(game))
    }
}
