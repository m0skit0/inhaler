package org.m0skit0.android.inhaler.domain.punch


interface PunchInteractor {
    suspend fun punch()
    suspend fun punch(punch: Punch)
}
