package br.com.lconeto.library.data.database.shoot

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.lconeto.library.data.positionsinterface.ShootHitPosition
import br.com.lconeto.library.data.positionsinterface.ShootJumpPosition
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "shoots")
data class Shoot(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val shootJumpPosition: ShootJumpPosition,
    val goalHitPosition: ShootHitPosition,
    val missShootHitPosition: ShootHitPosition
) : Parcelable
