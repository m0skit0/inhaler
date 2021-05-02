package org.m0skit0.android.inhaler.data.punch

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.m0skit0.android.inhaler.data.mock.MockData
import org.m0skit0.android.inhaler.data.model.PunchData
import javax.inject.Inject

class PunchRepositoryMock
@Inject constructor(
    private val mockData: MockData
) : PunchRepository {

    override suspend fun punch() {
        // Does nothing
    }

    override suspend fun punch(punchData: PunchData) {
        // Does nothing
    }

    override suspend fun delete(punchData: PunchData) {
        // Does nothing
    }

    override fun allPunches(): Flow<List<PunchData>> = flow {
        emit(mockData.punchDataList)
    }
}
