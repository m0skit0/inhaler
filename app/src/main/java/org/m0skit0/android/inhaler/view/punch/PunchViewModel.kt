package org.m0skit0.android.inhaler.view.punch

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.m0skit0.android.inhaler.domain.punch.PunchInteractor

class PunchViewModel
@ViewModelInject constructor(
    private val interactor: PunchInteractor
) : ViewModel() {
    fun onPunchClicked() {
        viewModelScope.launch {
            interactor.punch()
        }
    }
}
