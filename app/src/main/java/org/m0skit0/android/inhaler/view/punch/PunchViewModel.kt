package org.m0skit0.android.inhaler.view.punch

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.m0skit0.android.inhaler.domain.model.Punch
import org.m0skit0.android.inhaler.domain.punch.PunchInteractor
import java.util.*

class PunchViewModel
@ViewModelInject constructor(
    private val interactor: PunchInteractor
) : ViewModel() {
    fun onPunchClicked() {
        Punch(Date()).let { punch ->
            viewModelScope.launch {
                interactor.punch(punch)
            }
        }
    }
}
