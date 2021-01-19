package org.m0skit0.android.inhaler.data.punch

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.data.model.PunchData
import org.m0skit0.android.inhaler.data.model.PunchStatisticsData
import org.m0skit0.android.inhaler.data.stats.AverageCalculator
import org.m0skit0.android.inhaler.data.stats.SimpleStatisticsCalculator
import javax.inject.Inject

class StatisticsRepositoryImpl
@Inject constructor(
    private val punchRepository: PunchRepository,
    private val simpleStatisticsCalculator: SimpleStatisticsCalculator,
    private val averageCalculator: AverageCalculator
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

    private fun List<PunchData>.total(): Int =  simpleStatisticsCalculator.run { total() }
    private fun List<PunchData>.dailyAverage(): Double =  averageCalculator.run { dailyAverage() }
    private fun List<PunchData>.dailyMaximum(): Int =  simpleStatisticsCalculator.run { dailyMaximum() }
    private fun List<PunchData>.monthlyAverage(): Double =  averageCalculator.run { monthlyAverage() }

}
