package br.com.lconeto.library.domain.extensions

import android.text.format.DateFormat
import java.util.*

fun getFormattedCurrentDate(): String {
    return DateFormat.format("dd/MM/yyyy", Date()).toString()
}
