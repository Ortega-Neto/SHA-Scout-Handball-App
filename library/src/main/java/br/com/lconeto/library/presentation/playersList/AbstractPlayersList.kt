package br.com.lconeto.library.presentation.playersList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import br.com.lconeto.library.R
import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.databinding.FragmentPlayersListBinding
import br.com.lconeto.library.domain.listener.PlayersListRecyclerViewClickListener
import br.com.lconeto.library.presentation.base.BaseFragment
import br.com.lconeto.library.presentation.playersList.dialog.DialogInsertPlayer
import br.com.lconeto.library.presentation.playersList.viewModel.TeamListViewModel
import br.com.lconeto.library.presentation.playersList.viewModel.TeamListViewModelFactory

abstract class AbstractPlayersList :
    BaseFragment<FragmentPlayersListBinding>(),
    PlayersListRecyclerViewClickListener {

    private val viewModel by viewModels<TeamListViewModel> {
        TeamListViewModelFactory
    }

    private val _finishedEdition by lazy { MutableLiveData<Boolean>() }
    val finishedEdition: LiveData<Boolean> get() = _finishedEdition

    private lateinit var _dialogInsertPlayer: DialogInsertPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setupUi()
        subscribeUi()
        configureRecyclerView()
    }

    private fun setupUi() {
        binding.buttonTeamListFinishedEdition.buttonPrimary.setText(R.string.advance)
    }

    private fun subscribeUi() {
        binding.floatingActionButtonAddPlayer.setOnClickListener {
            _dialogInsertPlayer = DialogInsertPlayer()
            _dialogInsertPlayer.show(childFragmentManager, "DialogInsertPlayer")
            _dialogInsertPlayer.insertPlayer.observe(viewLifecycleOwner) {
                print("a")
            }
        }

        binding.buttonTeamListFinishedEdition.buttonPrimary.setOnClickListener {
        }

        viewModel.allPositionsInsert.observe(viewLifecycleOwner) {
            if (it) _finishedEdition.postValue(true)
        }
    }

    private fun configureRecyclerView() {
        binding.recyclerViewPlayers.also {
            it.layoutManager = GridLayoutManager(requireContext(), 2)
            it.setHasFixedSize(true)
        }
    }

    override fun onPlayerClickListener(player: Player) {
    }

//    it.adapter = PlayersListAdapter(
//    MainFeaturesList(requireContext()),
//    this
//    )
}
