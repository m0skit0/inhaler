package org.m0skit0.android.inhaler.domain.stats

import kotlinx.coroutines.flow.Flow

interface PunchStatisticsInteractor {
    fun statistics(): Flow<PunchStatistics>
}
