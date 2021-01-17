package org.m0skit0.android.inhaler.view.history

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.collect
import org.m0skit0.android.inhaler.domain.history.PunchHistoryInteractor

class PunchHistoryViewModel
@ViewModelInject constructor(
    private val interactor: PunchHistoryInteractor
) : ViewModel() {

    val punches: LiveData<List<PunchHistoryEntry>> = liveData {
        interactor.history().collect { list ->
            list.map { it.toPunchHistoryEntry() }.let { emit(it) }
        }
    }
}
