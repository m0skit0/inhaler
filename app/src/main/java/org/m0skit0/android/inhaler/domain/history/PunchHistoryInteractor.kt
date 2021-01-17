package org.m0skit0.android.inhaler.domain.history

import org.m0skit0.android.inhaler.domain.Punch

interface PunchHistoryInteractor {
    suspend fun history(): List<Punch>
}
