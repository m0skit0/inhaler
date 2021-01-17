package org.m0skit0.android.inhaler.domain.punch

import org.m0skit0.android.inhaler.domain.Punch

interface PunchInteractor {
    suspend fun punch(punch: Punch)
}