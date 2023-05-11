package br.com.lconeto.library.presentation.playersList.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.lconeto.library.R
import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.data.positionsInterface.PlayerPosition
import br.com.lconeto.library.databinding.DialogInsertPlayerBinding
import br.com.lconeto.library.domain.extensions.removeError
import br.com.lconeto.library.domain.extensions.setNeedToBeFilledError
import com.google.android.material.textfield.TextInputLayout

class DialogInsertPlayer(
    private val player: Player? = null
) : DialogFragment() {

    private var _binding: DialogInsertPlayerBinding? = null
    private val binding: DialogInsertPlayerBinding get() = _binding!!

    val insertPlayer: LiveData<Player> get() = _insertPlayer
    private val _insertPlayer = MutableLiveData<Player>()

    private lateinit var playerPosition: PlayerPosition

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
        player?.let {
            binding.viewPlayerFields.editTextInputPlayerName.setText(it.name)
            binding.viewPlayerFields.editTextInputPlayerNumber.setText(it.number.toString())
            setPositionAtShirt(it.position)

            binding.buttonInsertPlayer.buttonPrimary.setText(R.string.update)
        } ?: binding.buttonInsertPlayer.buttonPrimary.setText(R.string.insert)
    }

    private fun subscribeUi() {
        binding.buttonInsertPlayer.buttonPrimary.setOnClickListener { checkPlayerInserts() }

        binding.buttonInsertPlayerCancel.buttonCancel.setOnClickListener { dismiss() }

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
        binding.viewPlayerFields.editTextInputPlayerPosition.setText(position.value)
        playerPosition = position
    }

    private fun checkPlayerInserts() {
        binding.viewPlayerFields.textInputLayoutPlayerName.removeError()
        binding.viewPlayerFields.textInputLayoutPlayerNumber.removeError()
        binding.viewPlayerFields.textInputLayoutPlayerPosition.removeError()

        val checkName = checkPlayerInsert(
            textInputLayout = binding.viewPlayerFields.textInputLayoutPlayerName,
            editText = binding.viewPlayerFields.editTextInputPlayerName
        )

        val checkNumber = checkPlayerInsert(
            textInputLayout = binding.viewPlayerFields.textInputLayoutPlayerNumber,
            editText = binding.viewPlayerFields.editTextInputPlayerNumber
        )

        val checkPosition = checkPlayerInsert(
            textInputLayout = binding.viewPlayerFields.textInputLayoutPlayerPosition,
            editText = binding.viewPlayerFields.editTextInputPlayerPosition
        )

        if (checkName && checkNumber && checkPosition) {
            _insertPlayer.postValue(
                Player(
                    id = 0,
                    name = binding.viewPlayerFields.editTextInputPlayerName.text.toString(),
                    number = binding.viewPlayerFields.editTextInputPlayerNumber.text.toString().toInt(),
                    position = playerPosition
                )
            )
            dismiss()
        }
    }

    private fun checkPlayerInsert(
        textInputLayout: TextInputLayout,
        editText: EditText
    ): Boolean {
        return if (
            editText.text.toString().isEmpty()
        ) {
            textInputLayout.setNeedToBeFilledError()
            false
        } else {
            true
        }
    }
}
