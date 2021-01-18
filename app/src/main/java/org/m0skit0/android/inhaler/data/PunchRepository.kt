package org.m0skit0.android.inhaler.data

import kotlinx.coroutines.flow.Flow

interface PunchRepository {
    suspend fun punch(punch: PunchData)
    fun allPunches(): Flow<List<PunchData>>
    fun statistics(): Flow<PunchStatisticsData>
}
