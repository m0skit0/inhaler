package org.m0skit0.android.inhaler.view.history

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.m0skit0.android.inhaler.domain.history.PunchHistoryInteractor
import org.m0skit0.android.inhaler.domain.punch.PunchDeleteInteractor

class PunchHistoryViewModel
@ViewModelInject constructor(
    punchInteractor: PunchHistoryInteractor,
    private val deleteInteractor: PunchDeleteInteractor,
) : ViewModel() {

    val punches: LiveData<List<PunchHistoryEntry>> by lazy {
        punchInteractor.history().map { list ->
            list.map { it.toPunchHistoryEntry() }
        }.asLiveData()
    }

    fun delete(punch: PunchHistoryEntry) {
        viewModelScope.launch {
            deleteInteractor.delete(punch.toPunch())
        }
    }
}
