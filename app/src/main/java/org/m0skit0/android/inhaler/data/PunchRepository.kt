package org.m0skit0.android.inhaler.data

import kotlinx.coroutines.flow.Flow

interface PunchRepository {
    suspend fun storePunch(punch: PunchData)
    fun allPunches(): Flow<List<PunchData>>
}
