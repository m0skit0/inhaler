package org.m0skit0.android.inhaler.data.stats

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.m0skit0.android.inhaler.data.model.PunchData
import org.m0skit0.android.inhaler.data.model.PunchStatisticsData
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class StatisticsRepositoryMock @Inject constructor() : StatisticsRepository {

    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    private val punchDataList = listOf(
        "01/01/2020".toPunchData(),
        "01/01/2020".toPunchData(),
        "01/01/2020".toPunchData(),
        "15/01/2020".toPunchData(),
        "04/02/2020".toPunchData(),
        "07/04/2020".toPunchData(),
        "07/04/2020".toPunchData(),
        "30/08/2020".toPunchData(),
        "12/12/2020".toPunchData(),
    )

    override fun statistics(): Flow<PunchStatisticsData> = flow {
        with(punchDataList) {
            PunchStatisticsData(
                total(),
                dailyAverage(),
                dailyMaximum(),
                monthlyAverage()
            ).let { emit(it) }
        }
    }

    override fun punchesPerDay(): Flow<Map<Date, Int>> = flow {
        punchDataList.groupByDay().let { emit(it) }
    }

    private fun String.toPunchData(): PunchData = PunchData(toDate())

    private fun String.toDate(): Date = dateFormatter.parse(this)!!
}
