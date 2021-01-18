package org.m0skit0.android.inhaler.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.data.room.InhalerDatabase
import javax.inject.Inject

class PunchRepositoryImpl
@Inject constructor(
    database: InhalerDatabase
): PunchRepository {

    private val punchDao = database.punchDao()

    override suspend fun punch(punch: PunchData) {
        punchDao.insert(punch.toEntity())
    }

    override fun allPunches(): Flow<List<PunchData>> = punchDao.all().map { list -> list.map { it.toData() } }
}
