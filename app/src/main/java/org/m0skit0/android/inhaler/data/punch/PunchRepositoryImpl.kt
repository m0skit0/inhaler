package org.m0skit0.android.inhaler.data.punch

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.data.now
import org.m0skit0.android.inhaler.data.room.InhalerDatabase
import javax.inject.Inject

class PunchRepositoryImpl
@Inject constructor(
    database: InhalerDatabase
) : PunchRepository {

    private val punchDao = database.punchDao()
    private val inhalerDao = database.inhalerDao()
    private val inhalerId: Long
        get() = inhalerDao.current().id

    override suspend fun punch() {
        val punch = PunchData(now())
        punchDao.insert(punch.toEntity(inhalerId))
    }

    override suspend fun punch(punchData: PunchData) {
        val inhalerId = inhalerDao.current().id
        punchDao.insert(punchData.toEntity(inhalerId))
    }

    override suspend fun delete(punchData: PunchData) {
        punchDao.delete(punchData.toEntity(inhalerId))
    }

    override fun allPunches(): Flow<List<PunchData>> =
        punchDao.all().map { list -> list.map { it.toData() } }
}
