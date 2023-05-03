package br.com.lconeto.library.data.database.player.repository

import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.data.database.team.Team
import br.com.lconeto.library.data.model.shoot.Shoot

interface PlayerRepository {
    fun insertPlayer(player: Player): Boolean
    fun getAllPlayers(): List<Player>
    fun getPlayerById(playerId: Int): Player
    fun deletePlayer(player: Player): Boolean
    fun addTwoMinutes(player: Player): Boolean
    fun addYellowCard(player: Player): Boolean
    fun addRedCard(player: Player): Boolean
    fun addShoot(team: Team, player: Player, shoot: Shoot): Boolean
}
