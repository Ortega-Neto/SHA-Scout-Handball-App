package br.com.lconeto.library.presentation.playersList.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.lconeto.library.R
import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.data.positionsInterface.PlayerPosition
import br.com.lconeto.library.databinding.DialogInsertPlayerBinding

class DialogInsertPlayer : DialogFragment() {

    private var _binding: DialogInsertPlayerBinding? = null
    private val binding: DialogInsertPlayerBinding get() = _binding!!

    val insertPlayer: LiveData<Player> get() = _insertPlayer
    private val _insertPlayer = MutableLiveData<Player>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corner)

        isCancelable = false

        _binding = DialogInsertPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        dialog!!.window!!.apply {
            setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        setupUi()
        subscribeUi()
    }

    private fun setupUi() {
        binding.buttonInsertPlayer.buttonPrimary.setText(R.string.insert)
    }

    private fun subscribeUi() {
        binding.buttonInsertPlayerCancel.buttonCancel.setOnClickListener {
            dismiss()
        }

        binding.viewCourt.buttonInsertPlayerPositionGK.setOnClickListener {
            setPositionAtShirt(PlayerPosition.GOAL_KEEPER)
        }

        binding.viewCourt.buttonInsertPlayerPositionLW.setOnClickListener {
            setPositionAtShirt(PlayerPosition.LEFT_WING)
        }

        binding.viewCourt.buttonInsertPlayerPositionPV.setOnClickListener {
            setPositionAtShirt(PlayerPosition.PIVOT)
        }

        binding.viewCourt.buttonInsertPlayerPositionRW.setOnClickListener {
            setPositionAtShirt(PlayerPosition.RIGHT_WING)
        }

        binding.viewCourt.buttonInsertPlayerPositionLBC.setOnClickListener {
            setPositionAtShirt(PlayerPosition.LEFT_BACK_COURT)
        }

        binding.viewCourt.buttonInsertPlayerPositionCBC.setOnClickListener {
            setPositionAtShirt(PlayerPosition.CENTER_BACK_COURT)
        }

        binding.viewCourt.buttonInsertPlayerPositionRBC.setOnClickListener {
            setPositionAtShirt(PlayerPosition.RIGHT_BACK_COURT)
        }
    }

    private fun setPositionAtShirt(position: PlayerPosition) {
        binding.viewShirt.textViewPlayerPosition.text = position.value
    }
}
