package org.m0skit0.android.inhaler.view.stats

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.m0skit0.android.inhaler.domain.stats.PunchStatisticsInteractor

class PunchStatisticsViewModel
@ViewModelInject constructor(
    private val interactor: PunchStatisticsInteractor
) : ViewModel() {

    private val _statistics: MutableLiveData<PunchStatisticsView> = MutableLiveData()
    val statistics: LiveData<PunchStatisticsView> = _statistics.apply {
        // TODO Implement
        PunchStatisticsView(20, 3.5, 5, 96.2).let {
            _statistics.postValue(it)
        }
    }
}
