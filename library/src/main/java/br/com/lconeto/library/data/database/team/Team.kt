package br.com.lconeto.library.data.database.team

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.lconeto.library.data.database.player.Player
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "teams")
data class Team(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val players: List<Player> = emptyList(),
    var points: Int = 0
) : Parcelable
