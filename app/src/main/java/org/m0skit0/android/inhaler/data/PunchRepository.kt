package org.m0skit0.android.inhaler.data

interface PunchRepository {
    suspend fun storePunch(punch: PunchData)
    suspend fun allPunches(): List<PunchData>
}