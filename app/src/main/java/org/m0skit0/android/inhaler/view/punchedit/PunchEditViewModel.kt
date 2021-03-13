package org.m0skit0.android.inhaler.view.punchedit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.m0skit0.android.inhaler.domain.punch.PunchDeleteInteractor
import org.m0skit0.android.inhaler.domain.punch.PunchInteractor
import javax.inject.Inject

@HiltViewModel
class PunchEditViewModel
@Inject
constructor(
    private val punchInteractor: PunchInteractor,
    private val punchDeleteInteractor: PunchDeleteInteractor,
) : ViewModel() {

    fun edit(oldPunch: PunchEditDetails, newPunch: PunchEditDetails) {
        viewModelScope.launch {
            punchDeleteInteractor.delete(oldPunch.toPunch())
            punchInteractor.punch(newPunch.toPunch())
        }
    }
}
