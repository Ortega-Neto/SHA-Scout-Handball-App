package br.com.lconeto.newgame.presentation.view

import android.os.Bundle
import android.view.View
import br.com.lconeto.library.presentation.BaseFragment
import br.com.lconeto.newgame.R
import br.com.lconeto.newgame.databinding.FragmentGameDetailsBinding

class GameDetailsFragment : BaseFragment<FragmentGameDetailsBinding>(R.layout.fragment_game_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialBinding = FragmentGameDetailsBinding.bind(view)
    }
}
