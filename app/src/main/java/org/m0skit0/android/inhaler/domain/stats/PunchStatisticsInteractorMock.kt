package org.m0skit0.android.inhaler.domain.stats

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.data.stats.StatisticsRepository
import org.m0skit0.android.inhaler.di.NAMED_MOCK_STATISTICS_REPOSITORY
import org.m0skit0.android.inhaler.domain.model.PunchStatistics
import org.m0skit0.android.inhaler.domain.model.toPunchStatistics
import javax.inject.Inject
import javax.inject.Named

class PunchStatisticsInteractorMock
@Inject constructor(
    @Named(NAMED_MOCK_STATISTICS_REPOSITORY)
    private val repository: StatisticsRepository
): PunchStatisticsInteractor {
    override fun statistics(): Flow<PunchStatistics> = repository.statistics().map { it.toPunchStatistics() }
}
