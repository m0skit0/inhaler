package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.PunchData
import java.util.*
import javax.inject.Inject

class StatisticsCalculatorImpl @Inject constructor() : StatisticsCalculator {

    override fun List<PunchData>.total(): Int = size

    override fun List<PunchData>.dailyAverage(): Double =
        groupByYearMonthDay().punchesPerDay().averageNoNaN()

    override fun List<PunchData>.dailyMaximum(): Int {
        TODO("Not yet implemented")
    }

    override fun List<PunchData>.monthlyAverage(): Double {
        TODO("Not yet implemented")
    }

    private fun Date.toCalendar(): Calendar = Calendar.getInstance().apply {
        time = this@toCalendar
    }

    private fun List<PunchData>.groupByYearMonthDay(): Map<Int, Map<Int, Map<Int, List<PunchData>>>> =
        groupByYearMonth().mapValues {
            it.value.mapValues {
                it.value.groupBy {
                    it.time.toCalendar()[Calendar.DAY_OF_MONTH]
                }

            }
        }

    private fun List<PunchData>.groupByYearMonth(): Map<Int, Map<Int, List<PunchData>>> =
        groupBy { it.time.toCalendar()[Calendar.YEAR] }
            .mapValues {
                it.value.groupBy {
                    it.time.toCalendar()[Calendar.MONTH]
                }
            }

    private fun Map<Int, Map<Int, Map<Int, List<PunchData>>>>.punchesPerDay(): List<Int> =
        mapValues { it.value.mapValues { it.value.mapValues { it.value.size } } }
            .mapValues { it.value.mapValues { it.value.values.toList() } }
            .flatMap { it.value.values.toList() }
            .flatten()

    private fun Iterable<Int>.averageNoNaN() = average()
        .run {
            if (isNaN()) 0.0 else this
        }
}
