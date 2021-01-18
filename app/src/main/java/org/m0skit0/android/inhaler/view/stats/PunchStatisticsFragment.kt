package org.m0skit0.android.inhaler.view.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.m0skit0.android.inhaler.InhalerApplication
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.view.TitledFragment

class PunchStatisticsFragment : Fragment(), TitledFragment {

    override val title: String by lazy { InhalerApplication.instance.getString(R.string.statistics) }

    private val viewModel: PunchStatisticsViewModel by viewModels()

    private lateinit var total: TextView
    private lateinit var dailyAverage: TextView
    private lateinit var dailyMaximum: TextView
    private lateinit var monthlyAverage: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_statistics, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (view) {
            initializeViews()
            observeLiveData()
        }
    }

    private fun View.initializeViews() {
        total = findViewById(R.id.total_value)
        dailyAverage = findViewById(R.id.average_daily_value)
        dailyMaximum = findViewById(R.id.maximum_daily_value)
        monthlyAverage = findViewById(R.id.average_monthly_value)
    }

    private fun observeLiveData() {
        viewModel.statistics.observe(viewLifecycleOwner) {
            total.text = it.total.toString()
            dailyAverage.text = it.dailyAverage.toString()
            dailyMaximum.text = it.dailyMaximum.toString()
            monthlyAverage.text = it.monthlyAverage.toString()
        }
    }
}
