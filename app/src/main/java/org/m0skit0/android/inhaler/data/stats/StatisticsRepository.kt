package org.m0skit0.android.inhaler.data.stats

import kotlinx.coroutines.flow.Flow
import org.m0skit0.android.inhaler.data.model.PunchStatisticsData
import java.util.*

interface StatisticsRepository {
    fun statistics(): Flow<PunchStatisticsData>
    fun punchesPerDay(): Flow<Map<Date, Int>>
}
