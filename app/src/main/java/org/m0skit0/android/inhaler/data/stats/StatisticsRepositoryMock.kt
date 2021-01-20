package org.m0skit0.android.inhaler.data.stats

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.m0skit0.android.inhaler.data.mock.MockData
import org.m0skit0.android.inhaler.data.model.PunchStatisticsData
import java.util.*
import javax.inject.Inject

class StatisticsRepositoryMock
@Inject constructor(
    private val mockData: MockData
) : StatisticsRepository {

    override fun statistics(): Flow<PunchStatisticsData> = flow {
        with(mockData.punchDataList) {
            PunchStatisticsData(
                total(),
                dailyAverage(),
                dailyMaximum(),
                monthlyAverage()
            ).let { emit(it) }
        }
    }

    override fun punchesPerDay(): Flow<Map<Date, Int>> = flow {
        mockData.punchDataList.groupByDay().let { emit(it) }
    }
}
