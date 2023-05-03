package br.com.lconeto.newgame.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lconeto.library.presentation.BaseFragment
import br.com.lconeto.newgame.R
import br.com.lconeto.newgame.databinding.FragmentGameDetailsBinding

class GameDetailsFragment : BaseFragment<FragmentGameDetailsBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setupUi()
        subscribeUi()
    }

    private fun setupUi() {
        binding.textInputGameHomeTeam.editTextInputString.setHint(
            R.string.home_team
        )

        binding.textInputGameVisitorTeam.editTextInputString.setHint(
            R.string.visitor_team
        )
    }

    private fun subscribeUi() {
        binding.textInputGameDate.editTextInputDate.setOnClickListener {
            print("a")
        }
    }
}
