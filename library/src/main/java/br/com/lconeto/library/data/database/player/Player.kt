package br.com.lconeto.library.data.database.player

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
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
    val shootsId: Int,
    val twoMinutes: Int,
    val yellowCard: Int,
    val redCard: Int
) : Parcelable
