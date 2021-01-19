package org.m0skit0.android.inhaler.view.stats

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
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

    val punchesByDay: LiveData<Map<Date, Int>> by lazy {
        punchesByDayInteractor.punchesByDay().asLiveData()
    }
}
