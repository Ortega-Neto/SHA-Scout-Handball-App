package br.com.lconeto.library.data.database.game.repository

import br.com.lconeto.library.data.database.game.Game
import br.com.lconeto.library.data.database.game.GameDao
import br.com.lconeto.library.domain.helper.GameHelper
import kotlinx.coroutines.runBlocking

class GameRepositoryImpl(
    private val gameDao: GameDao,
    private val gameHelper: GameHelper
) : GameRepository {
    override fun insertGame(game: Game): Boolean = runBlocking {
        return@runBlocking try {
            gameDao.insertGame(game)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getAllGames(): List<Game> = runBlocking {
        return@runBlocking gameDao.getAllGames()
    }

    override fun getGameById(gameId: Int): Game = runBlocking {
        return@runBlocking gameDao.getGameById(gameId)
    }

    override fun deleteGame(game: Game): Boolean = runBlocking {
        return@runBlocking try {
            gameDao.deleteGame(game)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun finishFirstHalf(game: Game): Boolean = runBlocking {
        return@runBlocking try {
            game.firstHalfScore = gameHelper.returnGameScore(game)
            gameDao.insertGame(game)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun finishGame(game: Game): Boolean = runBlocking {
        return@runBlocking try {
            game.finalScore = gameHelper.returnGameScore(game)
            gameDao.insertGame(game)
            true
        } catch (e: Exception) {
            false
        }
    }
}
