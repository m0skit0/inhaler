package org.m0skit0.android.inhaler.data.stats

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.joda.time.DateTime
import org.m0skit0.android.inhaler.BuildConfig
import org.m0skit0.android.inhaler.data.generateAllDaysBetweenOldestAndNow
import org.m0skit0.android.inhaler.data.punch.PunchData
import org.m0skit0.android.inhaler.data.punch.PunchRepository
import org.m0skit0.android.inhaler.data.punch.PunchStatisticsData
import org.m0skit0.android.inhaler.data.toDayOnly
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

    override fun punchesPerDay(): Flow<Map<DateTime, Int>> = punchRepository.allPunches().map { punches ->
        val punchesDayOnly = punches.map { it.time.toDayOnly().let { PunchData(it) } }
        val allDays = punchesDayOnly.map { it.time }.generateAllDaysBetweenOldestAndNow()
        allDays.associateWith { day -> punchesDayOnly.count { it.time == day } }
    }
}
