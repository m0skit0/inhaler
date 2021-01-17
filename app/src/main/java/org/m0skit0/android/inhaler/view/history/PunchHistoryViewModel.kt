package org.m0skit0.android.inhaler.view.history

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.domain.history.PunchHistoryInteractor

class PunchHistoryViewModel
@ViewModelInject constructor(
    interactor: PunchHistoryInteractor
) : ViewModel() {

    val punches: LiveData<List<PunchHistoryEntry>> =
        interactor.history().map { list ->
            list.map { it.toPunchHistoryEntry() }
        }.asLiveData()
}
