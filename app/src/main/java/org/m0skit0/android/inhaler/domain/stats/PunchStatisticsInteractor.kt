package org.m0skit0.android.inhaler.domain.stats

import kotlinx.coroutines.flow.Flow
import org.m0skit0.android.inhaler.domain.model.PunchStatistics

interface PunchStatisticsInteractor {
    fun statistics(): Flow<PunchStatistics>
}
