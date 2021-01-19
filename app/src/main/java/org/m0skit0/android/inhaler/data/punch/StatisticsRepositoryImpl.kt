package org.m0skit0.android.inhaler.data.punch

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.data.model.PunchStatisticsData
import org.m0skit0.android.inhaler.data.stats.*
import java.util.*
import javax.inject.Inject

class StatisticsRepositoryImpl
@Inject constructor(
    private val punchRepository: PunchRepository,
) : StatisticsRepository {

    override fun statistics(): Flow<PunchStatisticsData> =
        punchRepository.allPunches().map { punches ->
            with(punches) {
                PunchStatisticsData(
                    total(),
                    dailyAverage(),
                    dailyMaximum(),
                    monthlyAverage()
                )
            }
        }

    override fun punchesPerDay(): Flow<Map<Date, Int>> = punchRepository.allPunches().map {
        it.groupByDay()
    }
}
