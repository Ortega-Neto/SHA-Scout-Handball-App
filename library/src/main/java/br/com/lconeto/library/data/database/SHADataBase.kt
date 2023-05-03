package br.com.lconeto.library.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.lconeto.library.data.database.game.Game
import br.com.lconeto.library.data.database.game.GameDao
import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.data.database.player.PlayerDao
import br.com.lconeto.library.data.database.team.Team
import br.com.lconeto.library.data.database.team.TeamDao

@Database(entities = [Game::class, Team::class, Player::class], version = 1)
abstract class SHADataBase : RoomDatabase() {
    abstract fun gameDao(): GameDao
    abstract fun teamDao(): TeamDao
    abstract fun playerDao(): PlayerDao
}
