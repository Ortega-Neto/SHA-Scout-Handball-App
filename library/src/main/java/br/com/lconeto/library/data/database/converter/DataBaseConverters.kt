package br.com.lconeto.library.data.database.converter

import androidx.room.TypeConverter
import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.data.database.team.Team
import br.com.lconeto.library.data.model.shoot.Shoot
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.Date

class DataBaseConverters {
    private val errorMessage = "Erro ao transoformar classe"

    @TypeConverter
    fun transformTeamIntoString(team: Team): String {
        return Gson().toJson(team)
    }

    @TypeConverter
    fun transformStringIntoTeam(string: String): Team {
        return try {
            Gson().fromJson(string, Team::class.java)
        } catch (e: Exception) {
            throw Exception("$errorMessage Time")
        }
    }

    @TypeConverter
    fun transformPlayerIntoString(player: Player): String {
        return Gson().toJson(player)
    }

    @TypeConverter
    fun transformStringIntoPlayer(string: String): Player {
        return try {
            Gson().fromJson(string, Player::class.java)
        } catch (e: Exception) {
            throw Exception("$errorMessage Jogador")
        }
    }

    @TypeConverter
    fun transformListOfPlayersIntoString(shoots: List<Player>): String {
        val type: Type = object :
            TypeToken<List<Player>>() {}.type
        return Gson().toJson(shoots, type)
    }

    @TypeConverter
    fun transformStringIntoListOfPlayers(optionValuesString: String): List<Player> {
        return try {
            val type: Type = object :
                TypeToken<List<Player>>() {}.type
            return Gson().fromJson(optionValuesString, type)
        } catch (e: Exception) {
            emptyList()
        }
    }

    @TypeConverter
    fun transformShootIntoString(shoot: Shoot): String {
        return Gson().toJson(shoot)
    }

    @TypeConverter
    fun transformStringIntoShoot(string: String): Shoot {
        return try {
            Gson().fromJson(string, Shoot::class.java)
        } catch (e: Exception) {
            throw Exception("$errorMessage Arremesso")
        }
    }

    @TypeConverter
    fun transformListOfShootsIntoString(shoots: List<Shoot>): String {
        val type: Type = object :
            TypeToken<List<Shoot>>() {}.type
        return Gson().toJson(shoots, type)
    }

    @TypeConverter
    fun transformStringIntoListOfShoots(optionValuesString: String): List<Shoot> {
        return try {
            val type: Type = object :
                TypeToken<List<Shoot>>() {}.type
            return Gson().fromJson(optionValuesString, type)
        } catch (e: Exception) {
            emptyList()
        }
    }
}
