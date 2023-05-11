package br.com.lconeto.library.presentation.playersList.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.data.positionsInterface.PlayerPosition
import br.com.lconeto.library.domain.helper.position.PositionHelper

class TeamListViewModel(
    private val positionHelper: PositionHelper
) : ViewModel() {

    private val _allPositionsInsert by lazy { MutableLiveData<Boolean>() }
    val allPositionsInsert: LiveData<Boolean> get() = _allPositionsInsert

    private val _playerInserted by lazy { MutableLiveData<Int>() }
    val playerInserted: LiveData<Int> get() = _playerInserted

    val enteredPlayers: MutableList<Player> = mutableListOf()

    fun addPlayer(player: Player) {
        enteredPlayers.add(player)
        addPosition(player.position)
        _playerInserted.postValue(enteredPlayers.size)
    }

    fun initializePositionHashMap() {
        positionHelper.initializePositionHashMap()
    }

    private fun addPosition(position: PlayerPosition) {
        positionHelper.addPositionToHashMap(
            selectedPosition = position
        )
    }

    fun verifyIfAllPositionHadAtLeastOneInsert() {
        _allPositionsInsert.postValue(
            positionHelper.verifyPositionHashMap()
        )
    }
}
