package org.m0skit0.android.inhaler.data

import org.m0skit0.android.inhaler.data.room.InhalerDatabase
import javax.inject.Inject

class PunchRepositoryImpl
@Inject constructor(
    database: InhalerDatabase
): PunchRepository {

    private val punchDao = database.punchDao()

    override suspend fun storePunch(punch: PunchData) {
        punchDao.insert(punch.toEntity())
    }

    override suspend fun allPunches(): List<PunchData> = punchDao.all().map { it.toData() }
}