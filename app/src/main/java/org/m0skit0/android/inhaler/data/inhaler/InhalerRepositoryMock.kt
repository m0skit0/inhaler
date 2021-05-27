package org.m0skit0.android.inhaler.data.inhaler

import org.m0skit0.android.inhaler.data.mock.MockData
import javax.inject.Inject

class InhalerRepositoryMock
@Inject
constructor(
    private val mockData: MockData
) : InhalerRepository {

    override suspend fun current(): InhalerData = mockData.inhalerDataList.last()

    override suspend fun all(): List<InhalerData> = mockData.inhalerDataList

    override suspend fun punchesForCurrent(): Int = mockData.punchDataList.filter {
        it.time >= current().startTime
    }.size

    override suspend fun punchesFor(inhaler: InhalerData): Int = mockData.punchDataList.filter {
        it.time >= inhaler.startTime
    }.size
}
