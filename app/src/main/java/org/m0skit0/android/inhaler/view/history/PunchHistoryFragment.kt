package org.m0skit0.android.inhaler.view.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import org.m0skit0.android.inhaler.InhalerApplication
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.view.TitledFragment
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class PunchHistoryFragment : Fragment(), TitledFragment {

    override val title: String by lazy { InhalerApplication.instance.getString(R.string.history) }

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

    class PunchHistoryAdapter(private val punches: List<PunchHistoryEntry>) : RecyclerView.Adapter<PunchHistoryViewHolder>() {

        companion object {
            private val DATE_FORMATTER = SimpleDateFormat("EEE HH:mm dd-MM-yyyy", Locale.US)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PunchHistoryViewHolder =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_punch_history, parent, false)
                .let { PunchHistoryViewHolder(it) }

        override fun onBindViewHolder(holder: PunchHistoryViewHolder, position: Int) {
            holder.entry.text = punches[position].toText()
        }

        override fun getItemCount(): Int = punches.size

        private fun PunchHistoryEntry.toText(): String = DATE_FORMATTER.format(time)
    }

    class PunchHistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val entry: TextView = view.findViewById(R.id.punch_history_entry)
    }
}
