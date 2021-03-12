package org.m0skit0.android.inhaler.view.punchdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.format.DateTimeFormat
import org.m0skit0.android.inhaler.R

@AndroidEntryPoint
class PunchDetailsFragment : Fragment() {

    companion object {
        private val DATE_TIME_FORMATTER = DateTimeFormat.forPattern("dd-MM-yyyy EEE HH:mm")
        private const val KEY_DETAILS = "KEY_DETAILS"
        fun params(punchDetails: PunchDetails): Bundle = bundleOf(KEY_DETAILS to punchDetails)
    }

    private val viewModel: PunchDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_punch_details, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.initializeViews()
    }

    private fun View.initializeViews() {
        findViewById<Button>(R.id.delete).setOnClickListener {
            viewModel.deletePunch()

        }
        findViewById<Button>(R.id.edit).setOnClickListener {
            TODO()
        }
        findViewById<TextView>(R.id.date).text =
            arguments?.getParcelable<PunchDetails>(KEY_DETAILS)?.let { details ->
                DATE_TIME_FORMATTER.print(details.time)
            } ?: ""
    }
}
