package br.com.lconeto.library.data.database.player.repository

import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.data.database.player.PlayerDao
import kotlinx.coroutines.runBlocking

class PlayerRepositoryImpl(
    private val playerDao: PlayerDao
) : PlayerRepository {
    override fun insertPlayer(player: Player): Boolean = runBlocking {
        return@runBlocking try {
            playerDao.insertPlayer(player)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getAllPlayers(): List<Player> = runBlocking {
        return@runBlocking playerDao.getAllPlayers()
    }

    override fun getPlayerById(playerId: Int): Player = runBlocking {
        return@runBlocking playerDao.getPlayerById(playerId)
    }

    override fun deletePlayer(game: Player): Boolean = runBlocking {
        return@runBlocking try {
            playerDao.deletePlayer(game)
            true
        } catch (e: Exception) {
            false
        }
    }
}
