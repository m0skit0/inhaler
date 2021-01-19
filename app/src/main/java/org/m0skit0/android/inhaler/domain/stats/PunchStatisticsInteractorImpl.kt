package org.m0skit0.android.inhaler.domain.stats

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.data.PunchRepository
import org.m0skit0.android.inhaler.domain.model.PunchStatistics
import org.m0skit0.android.inhaler.domain.model.toPunchStatistics
import javax.inject.Inject

class PunchStatisticsInteractorImpl
@Inject constructor(
    private val repository: PunchRepository
): PunchStatisticsInteractor {
    override fun statistics(): Flow<PunchStatistics> = repository.statistics().map { it.toPunchStatistics() }
}
