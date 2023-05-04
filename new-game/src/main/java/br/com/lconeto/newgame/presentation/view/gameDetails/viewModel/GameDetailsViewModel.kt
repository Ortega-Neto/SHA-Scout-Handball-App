package br.com.lconeto.newgame.presentation.view.gameDetails.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lconeto.library.data.database.game.Game
import br.com.lconeto.library.data.database.team.Team
import br.com.lconeto.library.domain.extensions.getHomeTeamOrSetBaseHomeTeam
import br.com.lconeto.library.domain.extensions.getHomeTeamOrSetBaseVisitorTeam
import br.com.lconeto.library.domain.extensions.getHourOrSetBaseHour
import br.com.lconeto.library.domain.helper.date.DateInsertHelper

class GameDetailsViewModel(
    private val dateInsertHelper: DateInsertHelper
) : ViewModel() {

    val selectedDate: LiveData<String> get() = dateInsertHelper.selectedDate

    private val _dateError by lazy { MutableLiveData<Boolean>() }
    val dateError: LiveData<Boolean> get() = _dateError

    private val _filledGame by lazy { MutableLiveData<Game>() }
    val filledGame: LiveData<Game> get() = _filledGame

    fun setupDateInsert(context: Context) {
        dateInsertHelper.insertDate(context)
    }

    fun verifyGameDetailsFormAndReturnGame(
        date: String,
        hour: String,
        homeTeam: String,
        visitorTeam: String
    ) {
        if (date.isEmpty()) {
            _dateError.postValue(true)
        } else {
            _filledGame.postValue(
                Game(
                    date = date,
                    hour = hour.getHourOrSetBaseHour(),
                    homeTeam = Team(name = homeTeam.getHomeTeamOrSetBaseHomeTeam()),
                    visitorTeam = Team(name = visitorTeam.getHomeTeamOrSetBaseVisitorTeam()),
                )
            )
        }
    }
}
