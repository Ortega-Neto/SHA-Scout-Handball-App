package br.com.lconeto.library.presentation.playersList.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lconeto.library.data.database.player.Player
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

        positionHelper.removePositionInHashMap(player.position)

        _playerDeleted.postValue(id)
    }

    fun initializePositionHashMap() {
        positionHelper.initializePositionHashMap()
    }

    fun verifyIfAllPositionHadAtLeastOneInsert() {
        _allPositionsInsert.postValue(
            positionHelper.verifyPositionHashMap()
        )
    }

    fun getEnteredNumbers(): List<Int> {
        val enteredNumbers = mutableListOf<Int>()
        enteredPlayers.forEach {
            enteredNumbers.add(it.number)
        }

        return enteredNumbers
    }
}
