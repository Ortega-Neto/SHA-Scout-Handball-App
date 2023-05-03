package br.com.lconeto.library.data.database.game.repository

import br.com.lconeto.library.data.database.game.Game

interface GameRepository {
    fun insertGame(game: Game): Boolean
    fun getAllGames(): List<Game>
    fun getGameById(gameId: Int): Game
    fun deleteGame(game: Game): Boolean
    fun finishFirstHalf(game: Game): Boolean
    fun finishGame(game: Game): Boolean
}
