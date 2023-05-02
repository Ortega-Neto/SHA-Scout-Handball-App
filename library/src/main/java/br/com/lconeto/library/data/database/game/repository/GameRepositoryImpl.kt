package br.com.lconeto.library.data.database.game.repository

import br.com.lconeto.library.data.database.game.Game
import br.com.lconeto.library.data.database.game.GameDao
import kotlinx.coroutines.runBlocking

class GameRepositoryImpl(
    private val gameDao: GameDao
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
}
