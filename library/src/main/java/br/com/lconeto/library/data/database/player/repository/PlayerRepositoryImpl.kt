package br.com.lconeto.library.data.database.player.repository

import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.data.database.player.PlayerDao
import br.com.lconeto.library.data.database.team.Team
import br.com.lconeto.library.data.database.team.repository.TeamRepository
import br.com.lconeto.library.data.model.shoot.Shoot
import kotlinx.coroutines.runBlocking

class PlayerRepositoryImpl(
    private val playerDao: PlayerDao,
    private val teamRepository: TeamRepository
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

    override fun addTwoMinutes(player: Player): Boolean = runBlocking {
        return@runBlocking try {
            player.twoMinutes += 1
            playerDao.insertPlayer(player)

            if (player.twoMinutes == MAX_TWO_MINUTES) {
                addRedCard(player)
            }

            true
        } catch (e: Exception) {
            false
        }
    }

    override fun addYellowCard(player: Player): Boolean = runBlocking {
        return@runBlocking try {
            player.yellowCard += 1
            playerDao.insertPlayer(player)

            if (player.yellowCard == MAX_YELLOW_CARD) {
                addTwoMinutes(player)
            }

            true
        } catch (e: Exception) {
            false
        }
    }

    override fun addRedCard(player: Player): Boolean = runBlocking {
        return@runBlocking try {
            player.redCard = 1
            playerDao.insertPlayer(player)

            true
        } catch (e: Exception) {
            false
        }
    }

    override fun addShoot(
        team: Team,
        player: Player,
        shoot: Shoot
    ): Boolean = runBlocking {
        return@runBlocking try {
            player.shoots.add(shoot)
            playerDao.insertPlayer(player)

            if (shoot.isGoal) {
                teamRepository.addPoint(team)
            }

            true
        } catch (e: Exception) {
            false
        }
    }

    private companion object {
        const val MAX_TWO_MINUTES = 3
        const val MAX_YELLOW_CARD = 3
    }
}
