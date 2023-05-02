package br.com.lconeto.library.data.database.player.repository

import br.com.lconeto.library.data.database.player.Player

interface PlayerRepository {
    fun insertPlayer(player: Player): Boolean
    fun getAllPlayers(): List<Player>
    fun getPlayerById(playerId: Int): Player
    fun deletePlayer(player: Player): Boolean
}
