package org.m0skit0.android.inhaler.data.punch

import kotlinx.coroutines.flow.Flow

interface PunchRepository {
    suspend fun punch()
    suspend fun punch(punchData: PunchData)
    suspend fun delete(punchData: PunchData)
    fun allPunches(): Flow<List<PunchData>>
}
