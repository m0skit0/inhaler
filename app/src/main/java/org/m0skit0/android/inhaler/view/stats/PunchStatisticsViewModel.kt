package org.m0skit0.android.inhaler.view.stats

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PunchStatisticsViewModel @ViewModelInject constructor() : ViewModel() {

    private val _statistics: MutableLiveData<PunchStatistics> = MutableLiveData()
    val statistics: LiveData<PunchStatistics> = _statistics.apply {
        // TODO Implement
        PunchStatistics(20, 3.5, 5, 96.2).let {
            _statistics.postValue(it)
        }
    }
}
