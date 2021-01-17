package org.m0skit0.android.inhaler.data

import javax.inject.Inject

class PunchRepositoryImpl @Inject constructor(): PunchRepository {
    override suspend fun storePunch(punch: PunchEntity) {
        // TODO Implement
        println("Punched $punch")
    }
}