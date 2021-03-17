package org.m0skit0.android.inhaler.view.punchedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.format.DateTimeFormat
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.data.now
import org.m0skit0.android.inhaler.view.toast

@AndroidEntryPoint
class PunchEditFragment : DialogFragment() {

    companion object {
        private val DATE_TIME_FORMATTER = DateTimeFormat.forPattern("dd-MM-yyyy EEE HH:mm")
        private const val KEY_DETAILS = "KEY_DETAILS"
        fun params(punchDetails: PunchEditDetails): Bundle = bundleOf(KEY_DETAILS to punchDetails)
    }

    private val viewModel: PunchEditViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_edit_punch_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setPunchDetails()
        view.initializeViews()
    }

    private fun setPunchDetails() {
        (arguments?.getParcelable(KEY_DETAILS) ?: PunchEditDetails(now())).let {
            viewModel.punchDetails(it)
        }
    }

    private fun View.initializeViews() {
        setPunchDetailInformation()
        setCancelButtonClickListener()
        setSaveButtonClickListener()
        setDateClickListener()
    }

    private fun View.setPunchDetailInformation() {
        viewModel.punchDetails().time.let {
            findViewById<TextView>(R.id.date).text = DATE_TIME_FORMATTER.print(it)
        }
    }

    private fun View.setCancelButtonClickListener() {
        findViewById<Button>(R.id.cancel).setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun View.setDateClickListener() {
        findViewById<TextView>(R.id.date).setOnClickListener {
            PunchDatePicker().show(parentFragmentManager, null)
        }
    }

    private fun toastSaveSuccess() {
        toast(R.string.punch_edit_success)
    }

    private fun View.setSaveButtonClickListener() {
        findViewById<Button>(R.id.save).setOnClickListener {
            viewModel.replace()
            toastSaveSuccess()
            findNavController().popBackStack()
        }
    }
}
