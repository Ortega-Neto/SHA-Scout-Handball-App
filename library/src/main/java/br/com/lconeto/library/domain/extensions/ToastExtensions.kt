package br.com.lconeto.library.domain.extensions

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toastShortMessage(message: String) {
    Toast.makeText(
        this.requireContext(),
        message,
        Toast.LENGTH_SHORT
    ).show()
}

fun Fragment.toastLongMessage(message: String) {
    Toast.makeText(
        this.requireContext(),
        message,
        Toast.LENGTH_LONG
    ).show()
}

fun Activity.toastShortMessage(message: String) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_SHORT
    ).show()
}

fun Activity.toastLongMessage(message: String) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_LONG
    ).show()
}

fun Fragment.toastAddPlayerMessage() {
    this.toastShortMessage(
        message = "Jogador adicionado na lista"
    )
}

fun Fragment.toastEditedPlayerMessage() {
    this.toastShortMessage(
        message = "Jogador editado"
    )
}

fun Fragment.toastDeletedPlayerMessage() {
    this.toastShortMessage(
        message = "Jogador excluído da lista"
    )
}
