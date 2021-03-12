package org.m0skit0.android.inhaler.view.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.format.DateTimeFormat
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.view.TitledFragment
import org.m0skit0.android.inhaler.view.punchdetails.PunchDetailsFragment
import org.m0skit0.android.inhaler.view.punchdetails.toPunchDetails

@AndroidEntryPoint
class PunchHistoryFragment : Fragment(), TitledFragment {

    override val titleId: Int = R.string.history

    private val viewModel: PunchHistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_history, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.punches.observe(viewLifecycleOwner) {
            view
                .findViewById<RecyclerView>(R.id.recycler_punches)
                .adapter = PunchHistoryAdapter(it)
        }
    }

    private fun onItemLongClicked(punch: PunchHistoryEntry) {
        punch.navigateToPunchDetails()
    }

    private fun PunchHistoryEntry.navigateToPunchDetails() {
        PunchDetailsFragment.params(toPunchDetails()).let { params ->
            findNavController().navigate(R.id.punchDetailsFragment, params)
        }
    }

    inner class PunchHistoryAdapter(private val punches: List<PunchHistoryEntry>) : RecyclerView.Adapter<PunchHistoryAdapter.PunchHistoryViewHolder>() {

        private val dateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yyyy EEE HH:mm")

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PunchHistoryViewHolder =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_punch_history, parent, false)
                .let { PunchHistoryViewHolder(it) }

        override fun onBindViewHolder(holder: PunchHistoryViewHolder, position: Int) {
            holder.entry.text = punches[position].toText()
        }

        override fun getItemCount(): Int = punches.size

        private fun PunchHistoryEntry.toText(): String = dateTimeFormatter.print(time)

        private fun onItemLongClicked(position: Int) {
            onItemLongClicked(punches[position])
        }

        inner class PunchHistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val entry: TextView = view.findViewById<TextView>(R.id.punch_history_entry).apply {
                setOnLongClickListener {
                    onItemLongClicked(adapterPosition)
                    true
                }
            }
        }
    }
}
