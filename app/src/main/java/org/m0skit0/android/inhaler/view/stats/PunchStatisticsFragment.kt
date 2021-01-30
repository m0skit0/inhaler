package org.m0skit0.android.inhaler.view.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.formatter.ValueFormatter
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.m0skit0.android.inhaler.InhalerApplication
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.view.TitledFragment
import java.text.DecimalFormat

@AndroidEntryPoint
class PunchStatisticsFragment : Fragment(), TitledFragment {

    override val title: String by lazy { InhalerApplication.instance.getString(R.string.statistics) }

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
        xAxis.valueFormatter = ChartXAxisValueFormatter
    }

    private fun observeStatistics() {
        viewModel.statistics.observe(viewLifecycleOwner) {
            total.text = it.total.toString()
            dailyAverage.text = it.dailyAverage.toText()
            dailyMaximum.text = it.dailyMaximum.toString()
            monthlyAverage.text = it.monthlyAverage.toText()
        }
    }

    private fun observeChart() {
        viewModel.punchesByDay.observe(viewLifecycleOwner) {
            with(chart) {
                data = it
                data.notifyDataChanged()
                notifyDataSetChanged()
            }
        }
    }

    private fun Double.toText(): String = DecimalFormat.getNumberInstance().format(this)

    private object ChartXAxisValueFormatter : ValueFormatter() {
        private val DATE_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy")
        override fun getFormattedValue(value: Float): String = DateTime(value.toLong()).run {
            DATE_FORMATTER.print(this)
        }
    }
}
