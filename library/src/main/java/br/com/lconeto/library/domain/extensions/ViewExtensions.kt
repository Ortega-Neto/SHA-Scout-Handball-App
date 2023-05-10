package br.com.lconeto.library.domain.extensions

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.verifyNullAndSetText(
    editText: EditText,
    text: String?
) {
    text?.let {
        this.removeErrorAndSetText(editText, it)
    } ?: this.setBaseError()
}

fun TextInputLayout.removeErrorAndSetText(
    editText: EditText,
    text: String
) {
    this.error = null
    this.isErrorEnabled = false
    editText.setText(text)
}

fun TextInputLayout.removeError() {
    this.error = null
    this.isErrorEnabled = false
}

private const val TEXT_INPUT_LAYOUT_BASE_ERR0R = "Erro ao preencher campo"
private const val TEXT_INPUT_LAYOUT_NOT_FILLED_ERR0R = "Campo obrigatório"

fun TextInputLayout.setBaseError() {
    this.error = TEXT_INPUT_LAYOUT_BASE_ERR0R
}

fun TextInputLayout.setNeedToBeFilledError() {
    this.error = TEXT_INPUT_LAYOUT_NOT_FILLED_ERR0R
}
