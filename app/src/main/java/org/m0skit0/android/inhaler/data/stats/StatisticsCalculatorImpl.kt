package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.PunchData
import java.util.*
import javax.inject.Inject

class StatisticsCalculatorImpl @Inject constructor() : StatisticsCalculator {

    override fun List<PunchData>.total(): Int = size

    override fun List<PunchData>.dailyAverage(): Double =
        groupByYearMonthDay().punchesPerDay().averageOrZero()

    override fun List<PunchData>.dailyMaximum(): Int =
        groupByYearMonthDay().punchesPerDay().maxByOrNull { it } ?: 0

    override fun List<PunchData>.monthlyAverage(): Double =
        groupByYearMonth().punchesPerMonth().averageOrZero()

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

    private fun Map<Int, Map<Int, List<PunchData>>>.punchesPerMonth(): List<Int> =
        mapValues { it.value.mapValues { it.value.size } }
            .flatMap { it.value.values.toList() }

    private fun Iterable<Int>.averageOrZero() = average()
        .run {
            if (isNaN()) 0.0 else this
        }
}
