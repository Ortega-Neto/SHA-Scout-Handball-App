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
import br.com.lconeto.library.domain.extensions.toastAddPlayerMessage
import br.com.lconeto.library.domain.extensions.toastDeletedPlayerMessage
import br.com.lconeto.library.domain.extensions.toastEditedPlayerMessage
import br.com.lconeto.library.domain.listener.PlayersListRecyclerViewClickListener
import br.com.lconeto.library.presentation.base.BaseFragment
import br.com.lconeto.library.presentation.playersList.adapter.PlayersListAdapter
import br.com.lconeto.library.presentation.playersList.dialog.DialogInsertPlayer
import br.com.lconeto.library.presentation.playersList.dialog.DialogOptionsPlayer
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
    private lateinit var _playersListAdapter: PlayersListAdapter

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

        viewModel.initializePositionHashMap()
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
                viewModel.addPlayer(it)
            }
        }

        binding.buttonTeamListFinishedEdition.buttonPrimary.setOnClickListener {
        }

        viewModel.allPositionsInsert.observe(viewLifecycleOwner) {
            if (it) _finishedEdition.postValue(true)
        }

        viewModel.playerInserted.observe(viewLifecycleOwner) {
            _playersListAdapter.notifyItemInserted(it)
            toastAddPlayerMessage()
        }

        viewModel.playerEdited.observe(viewLifecycleOwner) {
            _playersListAdapter.notifyItemChanged(it)
            toastEditedPlayerMessage()
        }

        viewModel.playerDeleted.observe(viewLifecycleOwner) {
            _playersListAdapter.notifyItemRemoved(it)
            toastDeletedPlayerMessage()
        }
    }

    private fun configureRecyclerView() {
        _playersListAdapter = PlayersListAdapter(
            players = viewModel.enteredPlayers,
            listenerPlayersList = this
        )
        binding.recyclerViewPlayers.also {
            it.layoutManager = GridLayoutManager(requireContext(), 2)
            it.setHasFixedSize(true)
            it.adapter = _playersListAdapter
        }
    }

    override fun onPlayerClickListener(id: Int, player: Player) {
        val dialogOptionsPlayer = DialogOptionsPlayer()
        dialogOptionsPlayer.show(childFragmentManager, "DialogOptionsPlayer")
        dialogOptionsPlayer.editPlayer.observe(viewLifecycleOwner) {
            editPlayer(id, player)
        }
        dialogOptionsPlayer.deletePlayer.observe(viewLifecycleOwner) {
            viewModel.deletePlayer(id, player)
        }
    }

    private fun editPlayer(id: Int, player: Player) {
        _dialogInsertPlayer = DialogInsertPlayer(player)
        _dialogInsertPlayer.show(childFragmentManager, "DialogEditPlayer")
        _dialogInsertPlayer.insertPlayer.observe(viewLifecycleOwner) {
            viewModel.editPlayer(id, it)
        }
    }
}
