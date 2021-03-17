package org.m0skit0.android.inhaler.view.punchdetails

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.format.DateTimeFormat
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.data.now
import org.m0skit0.android.inhaler.view.punchedit.PunchEditFragment
import org.m0skit0.android.inhaler.view.punchedit.toPunchEditDetails
import org.m0skit0.android.inhaler.view.toast

@AndroidEntryPoint
class PunchDetailsFragment : DialogFragment() {

    companion object {
        private val DATE_TIME_FORMATTER = DateTimeFormat.forPattern("dd-MM-yyyy EEE HH:mm")
        private const val KEY_DETAILS = "KEY_DETAILS"
        fun params(punchDetails: PunchDetails): Bundle = bundleOf(KEY_DETAILS to punchDetails)
    }

    private val viewModel: PunchDetailsViewModel by viewModels()

    private lateinit var punchDetails: PunchDetails

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = run {
        setPunchDetails()
        val view = activity?.layoutInflater?.inflate(R.layout.fragment_punch_details, null)?.apply { initializeViews() }
        AlertDialog.Builder(activity)
            .setView(view)
            .create()
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? = inflater.inflate(R.layout.fragment_punch_details, container, false)

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        setPunchDetails()
//        view.initializeViews()
//    }

    private fun setPunchDetails() {
        punchDetails = arguments?.getParcelable(KEY_DETAILS) ?: PunchDetails(now())
    }

    private fun View.initializeViews() {
        setPunchDetailInformation()
        setDeleteButtonClickListener()
        setEditButtonClickListener()
    }

    private fun View.setPunchDetailInformation() {
        findViewById<TextView>(R.id.date).text = DATE_TIME_FORMATTER.print(punchDetails.time)
    }

    private fun View.setDeleteButtonClickListener() {
        findViewById<Button>(R.id.delete).setOnClickListener {
            showDeleteConfirmationDialog(::toastDeleteCancel) {
                viewModel.delete(punchDetails)
                toastDeleteSuccess()
            }
        }
    }

    private fun showDeleteConfirmationDialog(cancelBlock: () -> Unit, okBlock: () -> Unit) {
        AlertDialog.Builder(activity)
            .setMessage(R.string.delete_history_entry_confirmation)
            .setTitle(R.string.delete_confirmation_title)
            .setPositiveButton(android.R.string.ok) { _, _ -> okBlock() }
            .setNegativeButton(android.R.string.cancel) { _, _ -> cancelBlock() }
            .show()
    }

    private fun toastDeleteSuccess() {
        toast(R.string.punch_deleted)
    }

    private fun toastDeleteCancel() {
        toast(R.string.punch_delete_cancel)
    }

    private fun View.setEditButtonClickListener() {
        findViewById<Button>(R.id.edit).setOnClickListener {
            PunchEditFragment.params(punchDetails.toPunchEditDetails()).let { params ->
//                findNavController().navigate(R.id.punchEditFragment, params)
            }
        }
    }
}
