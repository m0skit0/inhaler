package org.m0skit0.android.inhaler.domain.punch

import org.m0skit0.android.inhaler.domain.model.Punch

interface PunchDeleteInteractor {
    suspend fun delete(punch: Punch)
}
