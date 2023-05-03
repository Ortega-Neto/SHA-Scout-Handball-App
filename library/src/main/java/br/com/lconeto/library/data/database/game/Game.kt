package br.com.lconeto.library.data.database.game

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.lconeto.library.data.database.team.Team
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "games")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val time: String,
    val hour: String,
    val homeTeam: Team,
    val visitorTeam: Team,
    var firstHalfScore: String = "",
    var finalScore: String = ""
) : Parcelable
