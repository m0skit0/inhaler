package org.m0skit0.android.inhaler.view.punch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.m0skit0.android.inhaler.domain.punch.PunchInteractor

@HiltViewModel
class PunchViewModel constructor(
    private val interactor: PunchInteractor
) : ViewModel() {
    fun onPunchClicked() {
        viewModelScope.launch {
            interactor.punch()
        }
    }
}
