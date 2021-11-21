package org.m0skit0.android.inhaler.view.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.mikephil.charting.charts.LineChart
import dagger.hilt.android.AndroidEntryPoint
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.view.TitledFragment
import org.m0skit0.android.inhaler.view.isDarkModeOn

// TODO Fix for landscape mode: put stats and graph side by side
@AndroidEntryPoint
class PunchStatisticsFragment : Fragment(), TitledFragment {

    override val titleId: Int = R.string.statistics

    private val viewModel: PunchStatisticsViewModel by viewModels()

    private lateinit var total: TextView
    private lateinit var dailyAverage: TextView
    private lateinit var dailyMaximum: TextView
    private lateinit var monthlyAverage: TextView
    private lateinit var chart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_statistics, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            initializeViews()
            observeStatistics()
            observeChart()
        }
    }

    private fun View.initializeViews() {
        total = findViewById(R.id.total_value)
        dailyAverage = findViewById(R.id.average_daily_value)
        dailyMaximum = findViewById(R.id.maximum_daily_value)
        monthlyAverage = findViewById(R.id.average_monthly_value)
        chart = findViewById<LineChart>(R.id.punches_per_day).configure()
    }

    private fun LineChart.configure(): LineChart = apply {
        scaleY = 1.0f
        with(xAxis) {
            valueFormatter = PunchStatisticsViewModel.ChartXAxisValueFormatter
            textColor = color()
        }
        with(axisLeft) {
            textColor = color()
        }
    }

    private fun observeStatistics() {
        viewModel.statistics.observe(viewLifecycleOwner) {
            total.text = it.total
            dailyAverage.text = it.dailyAverage
            dailyMaximum.text = it.dailyMaximum
            monthlyAverage.text = it.monthlyAverage
        }
    }

    private fun observeChart() {
        viewModel.punchesByDay.observe(viewLifecycleOwner) {
            with(chart) {
                data = it
                data.notifyDataChanged()
                invalidate()
                notifyDataSetChanged()
            }
        }
    }

    private fun color(): Int =
        if (isDarkModeOn()) resources.getColor(R.color.white) else resources.getColor(R.color.black)
}
