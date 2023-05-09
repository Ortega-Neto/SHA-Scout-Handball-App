package br.com.lconeto.library.presentation.playersList.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lconeto.library.domain.helper.position.PositionHelper

class TeamListViewModel(
    private val positionHelper: PositionHelper
) : ViewModel() {

    private val _allPositionsInsert by lazy { MutableLiveData<Boolean>() }
    val allPositionsInsert: LiveData<Boolean> get() = _allPositionsInsert
}
