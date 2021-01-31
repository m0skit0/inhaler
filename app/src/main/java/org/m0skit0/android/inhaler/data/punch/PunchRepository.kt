package org.m0skit0.android.inhaler.data.punch

import kotlinx.coroutines.flow.Flow
import org.m0skit0.android.inhaler.data.model.PunchData

interface PunchRepository {
    suspend fun punch()
    suspend fun delete(punchData: PunchData)
    fun allPunches(): Flow<List<PunchData>>
}
