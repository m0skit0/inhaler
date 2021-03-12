package org.m0skit0.android.inhaler.view.stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.m0skit0.android.inhaler.InhalerApplication
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.domain.stats.PunchStatisticsInteractor
import org.m0skit0.android.inhaler.domain.stats.PunchesByDayInteractor
import javax.inject.Inject

@HiltViewModel
class PunchStatisticsViewModel
@Inject
constructor(
    statisticsInteractor: PunchStatisticsInteractor,
    punchesByDayInteractor: PunchesByDayInteractor,
) : ViewModel() {

    val statistics: LiveData<PunchStatisticsView> by lazy {
        statisticsInteractor.statistics().map { stats ->
            stats.toPunchStatisticsView()
        }.asLiveData()
    }

    val punchesByDay: LiveData<LineData> = punchesByDayInteractor.punchesByDay()
        .map { punchesByDay ->
            punchesByDay.entries
                .map { it.toEntry() }
                .let { entry ->
                    LineDataSet(entry, chartLabel).let { LineData(it) }
                }
        }.asLiveData()

    private val chartLabel by lazy { InhalerApplication.instance.getString(R.string.chartLabel) }

    private fun Map.Entry<DateTime, Int>.toEntry(): Entry = Entry(key.toFloat(), value.toFloat())

    private fun DateTime.toFloat(): Float = millis.toFloat()

    object ChartXAxisValueFormatter : ValueFormatter() {
        private val DATE_FORMATTER = DateTimeFormat.forPattern("dd/MM")
        override fun getFormattedValue(value: Float): String = DateTime(value.toLong()).run {
            DATE_FORMATTER.print(this)
        }
    }
}
