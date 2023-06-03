package br.com.lconeto.library.domain.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.content.ContextCompat.getSystemService
import br.com.lconeto.library.R
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

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.setDrawable(
    context: Context,
    @DrawableRes drawableId: Int
) {
    this.background = getDrawable(
        context,
        drawableId
    )
}
