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

    private val _playerEdited by lazy { MutableLiveData<Int>() }
    val playerEdited: LiveData<Int> get() = _playerEdited

    private val _playerDeleted by lazy { MutableLiveData<Int>() }
    val playerDeleted: LiveData<Int> get() = _playerDeleted

    val enteredPlayers: MutableList<Player> = mutableListOf()

    fun addPlayer(player: Player) {
        enteredPlayers.add(player)
        positionHelper.addPositionToHashMap(
            selectedPosition = player.position
        )
        _playerInserted.postValue(enteredPlayers.size)
    }

    fun editPlayer(id: Int, player: Player) {
        enteredPlayers[id] = player
        _playerEdited.postValue(id)
    }

    fun deletePlayer(id: Int, player: Player) {
        enteredPlayers.remove(player)

        if (checkToRemovePositionInHashMap(player.position)) {
            positionHelper.removePositionInHashMap(player.position)
        }

        _playerDeleted.postValue(id)
    }

    private fun checkToRemovePositionInHashMap(position: PlayerPosition): Boolean {
        var remove = true

        enteredPlayers.forEach {
            remove = it.position == position
        }

        return remove
    }

    fun initializePositionHashMap() {
        positionHelper.initializePositionHashMap()
    }

    fun verifyIfAllPositionHadAtLeastOneInsert() {
        _allPositionsInsert.postValue(
            positionHelper.verifyPositionHashMap()
        )
    }
}
