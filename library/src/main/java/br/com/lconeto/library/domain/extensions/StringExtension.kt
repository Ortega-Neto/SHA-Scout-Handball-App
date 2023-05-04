package br.com.lconeto.library.domain.extensions

private const val BASE_HOUR = "12h00min"
fun String.getHourOrSetBaseHour(): String {
    return this.ifEmpty {
        BASE_HOUR
    }
}

private const val BASE_HOME_TEAM = "Time da Casa"
fun String.getHomeTeamOrSetBaseHomeTeam(): String {
    return this.ifEmpty {
        BASE_HOME_TEAM
    }
}

private const val BASE_VISITOR_TEAM = "Time Visitante"
fun String.getHomeTeamOrSetBaseVisitorTeam(): String {
    return this.ifEmpty {
        BASE_VISITOR_TEAM
    }
}
