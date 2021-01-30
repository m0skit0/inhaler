package org.m0skit0.android.inhaler.data.stats

import kotlinx.coroutines.flow.Flow
import org.joda.time.DateTime
import org.m0skit0.android.inhaler.data.model.PunchStatisticsData

interface StatisticsRepository {
    fun statistics(): Flow<PunchStatisticsData>
    fun punchesPerDay(): Flow<Map<DateTime, Int>>
}
