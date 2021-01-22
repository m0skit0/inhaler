package org.m0skit0.android.inhaler.view.stats

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.InhalerApplication
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.domain.stats.PunchStatisticsInteractor
import org.m0skit0.android.inhaler.domain.stats.PunchesByDayInteractor
import java.util.*

class PunchStatisticsViewModel
@ViewModelInject constructor(
    statisticsInteractor: PunchStatisticsInteractor,
    punchesByDayInteractor: PunchesByDayInteractor,
) : ViewModel() {

    val statistics: LiveData<PunchStatisticsView> by lazy {
        statisticsInteractor.statistics().map { stats ->
            stats.toPunchStatisticsView()
        }.asLiveData()
    }

    val punchesByDay: LiveData<LineData> =
        punchesByDayInteractor.punchesByDay().map { punchesByDay ->
            punchesByDay.entries.map { punchByDay ->
                punchByDay.toEntry()
            }.let { entry ->
                LineDataSet(entry, chartLabel).let { LineData(it) }
            }
        }.asLiveData()

    private val chartLabel by lazy { InhalerApplication.instance.getString(R.string.chartLabel) }

    private fun Map.Entry<Date, Int>.toEntry(): Entry = Entry(key.toFloat(), value.toFloat())

    private fun Date.toFloat(): Float = time.toFloat()
}
