package br.com.lconeto.library.domain.helper.date

import android.app.DatePickerDialog
import android.content.Context
import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateInsertHelperImpl : DateInsertHelper {
    override val selectedDate by lazy { MutableLiveData<String>() }

    override fun insertDate(context: Context) {
        val calendar = Calendar.getInstance()
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                formatDateToView(calendar)
            }

        DatePickerDialog(
            context,
            dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun formatDateToView(calendar: Calendar) {
        val format = "dd/MM/yyyy"
        val simpleDateFormat = SimpleDateFormat(format, Locale.US)
        val formattedDate = simpleDateFormat.format(calendar.time)
        selectedDate.postValue(formattedDate)
    }
}
