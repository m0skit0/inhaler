package org.m0skit0.android.inhaler.view.punchdetails

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PunchDatePicker : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private val viewModel: PunchDetailsViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        viewModel.punchDetails().time.run {
            DatePickerDialog(
                this@PunchDatePicker.requireActivity(),
                this@PunchDatePicker,
                year,
                monthOfYear - 1,
                dayOfMonth
            )
        }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        viewModel.newDate(year, month + 1, dayOfMonth)
        PunchTimePicker().show(parentFragmentManager, null)
    }
}
