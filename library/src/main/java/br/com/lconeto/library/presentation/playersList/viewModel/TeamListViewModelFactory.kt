package br.com.lconeto.library.presentation.playersList.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lconeto.library.domain.helper.position.PositionHelperImpl

object TeamListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val positionHelper = PositionHelperImpl()
        val teamListViewModel = TeamListViewModel(
            positionHelper = positionHelper
        )

        return teamListViewModel as T
    }
}
