package br.com.lconeto.library.data.database.team.repository

import br.com.lconeto.library.data.database.team.Team
import br.com.lconeto.library.data.database.team.TeamDao
import kotlinx.coroutines.runBlocking

class TeamRepositoryImpl(
    private val teamDao: TeamDao
) : TeamRepository {
    override fun insertTeam(team: Team): Boolean = runBlocking {
        return@runBlocking try {
            teamDao.insertTeam(team)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getAllTeams(): List<Team> = runBlocking {
        return@runBlocking teamDao.getAllTeams()
    }

    override fun getTeamById(teamId: Int): Team = runBlocking {
        return@runBlocking teamDao.getTeamById(teamId)
    }

    override fun deleteTeam(team: Team): Boolean = runBlocking {
        return@runBlocking try {
            teamDao.deleteTeam(team)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun addPoint(team: Team): Boolean = runBlocking {
        return@runBlocking try {
            team.points += 1
            teamDao.insertTeam(team)

            true
        } catch (e: Exception) {
            false
        }
    }
}
