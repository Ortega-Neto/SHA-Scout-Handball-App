package br.com.lconeto.library.domain.helper.date

import android.content.Context
import androidx.lifecycle.MutableLiveData

interface DateInsertHelper {
    val selectedDate: MutableLiveData<String>
    fun insertDate(context: Context)
}
