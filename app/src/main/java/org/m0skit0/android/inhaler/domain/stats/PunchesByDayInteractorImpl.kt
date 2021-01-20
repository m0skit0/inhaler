package org.m0skit0.android.inhaler.domain.stats

import kotlinx.coroutines.flow.Flow
import org.m0skit0.android.inhaler.BuildConfig
import org.m0skit0.android.inhaler.data.stats.StatisticsRepository
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class PunchesByDayInteractorImpl
@Inject constructor(
    @Named(BuildConfig.NAMED_STATISTICS_REPOSITORY)
    private val repository: StatisticsRepository
) : PunchesByDayInteractor {
    override fun punchesByDay(): Flow<Map<Date, Int>> = repository.punchesPerDay()
}
