package br.com.lconeto.library.data.database.team.repository

import br.com.lconeto.library.data.database.team.Team

interface TeamRepository {
    fun insertTeam(team: Team): Boolean
    fun getAllTeams(): List<Team>
    fun getTeamById(teamId: Int): Team
    fun deleteTeam(team: Team): Boolean
    fun addPoint(team: Team): Boolean
}
