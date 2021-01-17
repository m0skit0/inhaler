package org.m0skit0.android.inhaler.domain

interface PunchInteractor {
    suspend fun punch(punch: Punch)
}