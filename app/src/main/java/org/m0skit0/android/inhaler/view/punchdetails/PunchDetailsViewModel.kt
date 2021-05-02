package org.m0skit0.android.inhaler.view.punchdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.m0skit0.android.inhaler.data.now
import org.m0skit0.android.inhaler.domain.punch.PunchDeleteInteractor
import org.m0skit0.android.inhaler.domain.punch.PunchInteractor
import javax.inject.Inject

@HiltViewModel
class PunchDetailsViewModel
@Inject
constructor(
    private val punchInteractor: PunchInteractor,
    private val deleteInteractor: PunchDeleteInteractor,
) : ViewModel() {

    private val _punchDetails = MutableLiveData<PunchDetails>()
    val punchDetails: LiveData<PunchDetails> by lazy {
        _punchDetails
    }

    private lateinit var oldPunchDetails: PunchDetails
    private var newPunchDetails: PunchDetails = PunchDetails(now())
        set(value) {
            field = value
            _punchDetails.postValue(newPunchDetails)
        }

    fun delete() {
        viewModelScope.launch {
            deleteInteractor.delete(oldPunchDetails.toPunch())
        }
    }

    fun punchDetails(punchDetails: PunchDetails) {
        oldPunchDetails = punchDetails
        newPunchDetails = punchDetails
    }

    fun punchDetails(): PunchDetails = newPunchDetails

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
        newPunchDetails = PunchDetails(newPunchTime)
    }

    fun newTime(hourOfDay: Int, minutes: Int) {
        val newPunchTime = newPunchDetails
            .time
            .withHourOfDay(hourOfDay)
            .withMinuteOfHour(minutes)
        newPunchDetails = PunchDetails(newPunchTime)
    }
}
