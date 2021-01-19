package org.m0skit0.android.inhaler.domain.stats

import kotlinx.coroutines.flow.Flow
import org.m0skit0.android.inhaler.data.stats.StatisticsRepository
import java.util.*
import javax.inject.Inject

class PunchesByDayInteractorImpl
@Inject constructor(
    private val repository: StatisticsRepository
) : PunchesByDayInteractor {
    override fun punchesByDay(): Flow<Map<Date, Int>> = repository.punchesPerDay()
}
