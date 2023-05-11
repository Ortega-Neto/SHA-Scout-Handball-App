package br.com.lconeto.library.presentation.playersList.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.lconeto.library.R
import br.com.lconeto.library.databinding.DialogOptionsPlayerBinding

class DialogOptionsPlayer : DialogFragment() {

    private var _binding: DialogOptionsPlayerBinding? = null
    private val binding: DialogOptionsPlayerBinding get() = _binding!!

    val editPlayer: LiveData<Boolean> get() = _editPlayer
    private val _editPlayer = MutableLiveData<Boolean>()

    val deletePlayer: LiveData<Boolean> get() = _deletePlayer
    private val _deletePlayer = MutableLiveData<Boolean>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corner)

        isCancelable = true

        _binding = DialogOptionsPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        dialog!!.window!!.apply {
            setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        setupUi()
        subscribeUi()
    }

    private fun setupUi() {
        binding.buttonOptionPlayerEdit.buttonPrimary.setText(R.string.edit)
        binding.buttonOptionPlayerDelete.buttonCancel.setText(R.string.delet)
    }

    private fun subscribeUi() {
        binding.buttonOptionPlayerEdit.buttonPrimary.setOnClickListener {
            _editPlayer.postValue(true)
            dismiss()
        }

        binding.buttonOptionPlayerDelete.buttonCancel.setOnClickListener {
            _deletePlayer.postValue(true)
            dismiss()
        }
    }
}
