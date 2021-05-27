package org.m0skit0.android.inhaler.data.inhaler

import org.m0skit0.android.inhaler.data.room.InhalerDatabase
import javax.inject.Inject

class InhalerRepositoryImpl
@Inject constructor(
    database: InhalerDatabase
) : InhalerRepository {

    private val inhalerDao = database.inhalerDao()

    override suspend fun current(): InhalerData = inhalerDao.current().toData()

    override suspend fun all(): List<InhalerData> = inhalerDao.all().map { it.toData() }

    override suspend fun punchesForCurrent(): Int = inhalerDao.current().id.let { inhalerDao.punchesCount(it) }

    override suspend fun punchesFor(inhaler: InhalerData): Int = inhalerDao.punchesCount(inhaler.id)
}
