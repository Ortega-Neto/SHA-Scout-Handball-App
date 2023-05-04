package br.com.lconeto.newgame.presentation.view.gameDetails.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lconeto.library.domain.helper.date.DateInsertHelperImpl

object GameDetailsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dateHelper = DateInsertHelperImpl()
        val gameDetailsViewModel = GameDetailsViewModel(
            dateInsertHelper = dateHelper
        )

        return gameDetailsViewModel as T
    }
}
