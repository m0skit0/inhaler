package org.m0skit0.android.inhaler.view.punchdetails

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.m0skit0.android.inhaler.data.is24hFormat

@AndroidEntryPoint
class PunchTimePicker : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    private val viewModel: PunchDetailsViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        viewModel.punchDetails().time.run {
            val context = this@PunchTimePicker.requireActivity()
            TimePickerDialog(
                context,
                this@PunchTimePicker,
                hourOfDay,
                minuteOfHour,
                context.is24hFormat()
            )
        }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        viewModel.newTime(hourOfDay, minute)
    }
}
