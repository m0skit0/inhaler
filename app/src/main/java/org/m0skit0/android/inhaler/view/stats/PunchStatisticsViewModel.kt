package org.m0skit0.android.inhaler.view.stats

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.coroutines.flow.map
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
        punchesByDayInteractor.punchesByDay().map {
            it.entries.map { it.toEntry() }.let {
                LineDataSet(it, "Test").let {
                    LineData(it)
                }
            }
        }.asLiveData()

    private fun Map.Entry<Date, Int>.toEntry(): Entry = Entry(key.toFloat(), value.toFloat())

    private fun Date.toFloat(): Float = time.toFloat()
}
