package org.m0skit0.android.inhaler.domain.stats

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.BuildConfig
import org.m0skit0.android.inhaler.data.stats.StatisticsRepository
import javax.inject.Inject
import javax.inject.Named

class PunchStatisticsInteractorImpl
@Inject constructor(
    @Named(BuildConfig.NAMED_STATISTICS_REPOSITORY)
    private val repository: StatisticsRepository
): PunchStatisticsInteractor {
    override fun statistics(): Flow<PunchStatistics> = repository.statistics().map { it.toPunchStatistics() }
}
