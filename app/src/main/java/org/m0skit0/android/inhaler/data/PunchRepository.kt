package org.m0skit0.android.inhaler.data

import kotlinx.coroutines.flow.Flow

interface PunchRepository {
    suspend fun storePunch(punch: PunchData)
    suspend fun allPunches(): Flow<List<PunchData>>
}
