package br.com.lconeto.library.data.database.team

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(player: Team)

    @Delete
    suspend fun deleteTeam(player: Team)

    @Query("SELECT * FROM teams")
    suspend fun getAllTeams(): List<Team>

    @Query("SELECT * FROM teams WHERE id == :teamId")
    suspend fun getTeamById(teamId: Int): Team
}
