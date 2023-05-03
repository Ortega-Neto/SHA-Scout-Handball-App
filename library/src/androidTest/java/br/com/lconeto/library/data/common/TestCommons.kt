package br.com.lconeto.library.data.common

import br.com.lconeto.library.data.database.game.Game
import br.com.lconeto.library.data.database.team.Team

val homeTeam = Team(
    id = 0,
    name = "Home Team",
    players = emptyList(),
    points = 0
)

val visitorTeam = Team(
    id = 0,
    name = "Visitor Team",
    players = emptyList(),
    points = 0
)

val game = Game(
    id = 0,
    date = "02/05/2023",
    hour = "12h30min",
    homeTeam = homeTeam,
    visitorTeam = visitorTeam,
    firstHalfScore = "",
    finalScore = ""
)
