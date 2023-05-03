package br.com.lconeto.library.data.database.player

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.lconeto.library.data.model.shoot.Shoot
import br.com.lconeto.library.data.positionsinterface.PlayerPosition
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "players")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val number: Int,
    val position: PlayerPosition,
    val shoots: MutableList<Shoot> = mutableListOf(),
    var twoMinutes: Int = 0,
    var yellowCard: Int = 0,
    var redCard: Int = 0
) : Parcelable
