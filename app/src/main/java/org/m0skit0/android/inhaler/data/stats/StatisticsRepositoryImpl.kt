package org.m0skit0.android.inhaler.data.stats

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.joda.time.DateTime
import org.m0skit0.android.inhaler.BuildConfig
import org.m0skit0.android.inhaler.data.model.PunchStatisticsData
import org.m0skit0.android.inhaler.data.punch.PunchRepository
import javax.inject.Inject
import javax.inject.Named

class StatisticsRepositoryImpl
@Inject constructor(
    @Named(BuildConfig.NAMED_PUNCH_REPOSITORY)
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

    override fun punchesPerDay(): Flow<Map<DateTime, Int>> = TODO()
}
