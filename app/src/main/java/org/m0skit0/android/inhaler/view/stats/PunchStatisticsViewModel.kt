package org.m0skit0.android.inhaler.view.stats

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.domain.stats.PunchStatisticsInteractor

class PunchStatisticsViewModel
@ViewModelInject constructor(
    interactor: PunchStatisticsInteractor
) : ViewModel() {

    val statistics: LiveData<PunchStatisticsView> by lazy {
        interactor.statistics().map { stats ->
            stats.toPunchStatisticsView()
        }.asLiveData()
    }
}
