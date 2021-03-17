package org.m0skit0.android.inhaler.view.punchedit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.m0skit0.android.inhaler.domain.punch.PunchDeleteInteractor
import org.m0skit0.android.inhaler.domain.punch.PunchInteractor
import org.m0skit0.android.inhaler.view.punchdetails.PunchDetails
import org.m0skit0.android.inhaler.view.punchdetails.toPunch
import javax.inject.Inject

@HiltViewModel
class PunchEditViewModel
@Inject
constructor(
    private val punchInteractor: PunchInteractor,
    private val deleteInteractor: PunchDeleteInteractor,
) : ViewModel() {

    private lateinit var oldPunchDetails: PunchEditDetails
    private lateinit var newPunchDetails: PunchEditDetails

    fun delete(punch: PunchDetails) {
        viewModelScope.launch {
            deleteInteractor.delete(punch.toPunch())
        }
    }

    fun punchDetails(punchDetails: PunchEditDetails) {
        oldPunchDetails = punchDetails
        newPunchDetails = punchDetails
    }

    fun punchDetails(): PunchEditDetails = newPunchDetails

    fun replace() {
        viewModelScope.launch {
            deleteInteractor.delete(oldPunchDetails.toPunch())
            punchInteractor.punch(newPunchDetails.toPunch())
        }
    }

    fun newDate(year: Int, month: Int, dayOfMonth: Int) {
        val newPunchTime = newPunchDetails
            .time
            .withYear(year)
            .withMonthOfYear(month)
            .withDayOfMonth(dayOfMonth)
        newPunchDetails = PunchEditDetails(newPunchTime)
    }

    fun newTime(hourOfDay: Int, minutes: Int) {
        val newPunchTime = newPunchDetails
            .time
            .withHourOfDay(hourOfDay)
            .withMinuteOfHour(minutes)
        newPunchDetails = PunchEditDetails(newPunchTime)
    }
}
