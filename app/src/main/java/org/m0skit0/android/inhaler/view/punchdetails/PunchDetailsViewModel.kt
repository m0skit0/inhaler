package org.m0skit0.android.inhaler.view.punchdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.m0skit0.android.inhaler.domain.punch.PunchDeleteInteractor
import javax.inject.Inject

@HiltViewModel
class PunchDetailsViewModel
@Inject
constructor(
    private val deleteInteractor: PunchDeleteInteractor
) : ViewModel() {
    fun delete(punch: PunchDetails) {
        viewModelScope.launch {
            deleteInteractor.delete(punch.toPunch())
        }
    }
}
