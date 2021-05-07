package org.m0skit0.android.inhaler.view.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.domain.history.PunchHistoryInteractor
import javax.inject.Inject

@HiltViewModel
class PunchHistoryViewModel
@Inject
constructor(
    punchInteractor: PunchHistoryInteractor,
) : ViewModel() {

    val punches: LiveData<List<PunchHistoryEntry>> by lazy {
        punchInteractor.history()
            .map { list ->
                list.map { it.toPunchHistoryEntry() }
            }.asLiveData()
    }
}
