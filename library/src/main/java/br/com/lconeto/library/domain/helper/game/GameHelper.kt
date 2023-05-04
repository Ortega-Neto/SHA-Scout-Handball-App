package br.com.lconeto.library.domain.helper.game

import br.com.lconeto.library.data.database.game.Game
import br.com.lconeto.library.data.database.team.Team

class GameHelper {
    fun returnGameScore(game: Game): String {
        val homeScore = returnTeamScore(game.homeTeam)
        val visitorScore = returnTeamScore(game.homeTeam)

        return "$homeScore X $visitorScore"
    }

    private fun returnTeamScore(team: Team): String {
        return "${team.name} ${team.points}"
    }
}
