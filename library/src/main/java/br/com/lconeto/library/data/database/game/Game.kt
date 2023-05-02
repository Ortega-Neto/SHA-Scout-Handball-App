package br.com.lconeto.library.data.database.game

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "games")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val time: String,
    val hour: String,
    val homeTeam: String,
    val visitorTeam: String,
    val firstHalfScore: String,
    val finalScore: String
) : Parcelable
