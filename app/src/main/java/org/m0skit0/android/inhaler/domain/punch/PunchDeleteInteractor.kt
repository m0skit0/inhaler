package org.m0skit0.android.inhaler.domain.punch

interface PunchDeleteInteractor {
    suspend fun delete(punch: Punch)
}
