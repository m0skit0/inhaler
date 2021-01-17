package org.m0skit0.android.inhaler.domain.history

import kotlinx.coroutines.flow.Flow
import org.m0skit0.android.inhaler.domain.Punch

interface PunchHistoryInteractor {
    fun history(): Flow<List<Punch>>
}
