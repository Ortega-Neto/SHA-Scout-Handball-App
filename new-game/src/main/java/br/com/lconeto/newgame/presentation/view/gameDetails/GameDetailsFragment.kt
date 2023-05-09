package br.com.lconeto.newgame.presentation.view.gameDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.lconeto.library.data.database.game.Game
import br.com.lconeto.library.domain.extensions.setNeedToBeFilledError
import br.com.lconeto.library.domain.extensions.verifyNullAndSetText
import br.com.lconeto.library.presentation.base.BaseFragment
import br.com.lconeto.newgame.R
import br.com.lconeto.newgame.databinding.FragmentGameDetailsBinding
import br.com.lconeto.newgame.presentation.view.gameDetails.viewModel.GameDetailsViewModel
import br.com.lconeto.newgame.presentation.view.gameDetails.viewModel.GameDetailsViewModelFactory

class GameDetailsFragment : BaseFragment<FragmentGameDetailsBinding>() {

    private val viewModel by viewModels<GameDetailsViewModel> {
        GameDetailsViewModelFactory
    }

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

        binding.buttonAdvanceGameDetails.buttonPrimary.setText(
            br.com.lconeto.library.R.string.advance
        )
    }

    private fun subscribeUi() {
        binding.textInputGameDate.editTextInputDate.setOnClickListener {
            viewModel.setupDateInsert(context = requireContext())
        }

        binding.buttonAdvanceGameDetails.buttonPrimary.setOnClickListener {
            verifyGameDetailsForm()
        }

        viewModel.selectedDate.observe(viewLifecycleOwner, ::setDateView)
        viewModel.dateError.observe(viewLifecycleOwner) {
            binding.textInputGameDate.textInputLayout.setNeedToBeFilledError()
        }
        viewModel.filledGame.observe(viewLifecycleOwner, ::navigateToHomeTeamFragment)
    }

    private fun setDateView(date: String?) {
        binding.textInputGameDate.textInputLayout.verifyNullAndSetText(
            editText = binding.textInputGameDate.editTextInputDate,
            text = date
        )
    }

    private fun verifyGameDetailsForm() {
        viewModel.verifyGameDetailsFormAndReturnGame(
            date = binding.textInputGameDate.editTextInputDate.text.toString(),
            hour = binding.textInputGameHour.editTextInputHour.text.toString(),
            homeTeam = binding.textInputGameHomeTeam.editTextInputString.text.toString(),
            visitorTeam = binding.textInputGameVisitorTeam.editTextInputString.text.toString()
        )
    }

    private fun navigateToHomeTeamFragment(game: Game) {
        val action = GameDetailsFragmentDirections
            .actionGameDatailsFragmentToHomeTeamFragment(
                gameForm = game
            )
        findNavController().navigate(action)
    }
}
