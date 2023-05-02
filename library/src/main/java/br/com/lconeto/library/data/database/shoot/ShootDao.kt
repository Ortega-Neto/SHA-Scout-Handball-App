package br.com.lconeto.library.data.database.shoot

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShootDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoot(player: Shoot)

    @Delete
    suspend fun deleteShoot(player: Shoot)

    @Query("SELECT * FROM shoots")
    suspend fun getAllShoots(): List<Shoot>

    @Query("SELECT * FROM shoots WHERE id == :shootId")
    suspend fun getShootById(shootId: Int): Shoot
}
