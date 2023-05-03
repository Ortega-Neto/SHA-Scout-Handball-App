package br.com.lconeto.library.data.model.shoot

import android.os.Parcelable
import br.com.lconeto.library.data.positionsinterface.ShootHitPosition
import br.com.lconeto.library.data.positionsinterface.ShootJumpPosition
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoot(
    val shootJumpPosition: ShootJumpPosition,
    val shootHitPosition: ShootHitPosition,
    val isGoal: Boolean
) : Parcelable
