package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData
import java.util.*

fun List<PunchData>.groupByYearMonthDay(): Map<Int, Map<Int, Map<Int, List<PunchData>>>> =
    groupByYearMonth().mapValues {
        it.value.mapValues {
            it.value.groupBy {
                it.time.toCalendar()[Calendar.DAY_OF_MONTH]
            }

        }
    }

fun List<PunchData>.groupByYearMonth(): Map<Int, Map<Int, List<PunchData>>> =
    groupBy { it.time.toCalendar()[Calendar.YEAR] }
        .mapValues {
            it.value.groupBy {
                it.time.toCalendar()[Calendar.MONTH]
            }
        }

private fun Date.toCalendar(): Calendar = Calendar.getInstance().apply {
    time = this@toCalendar
}

fun Map<Int, Map<Int, Map<Int, List<PunchData>>>>.punchesPerDay(): List<Int> =
    mapValues { it.value.mapValues { it.value.mapValues { it.value.size } } }
        .mapValues { it.value.mapValues { it.value.values.toList() } }
        .flatMap { it.value.values.toList() }
        .flatten()

fun Map<Int, Map<Int, List<PunchData>>>.punchesPerMonth(): List<Int> =
    mapValues { it.value.mapValues { it.value.size } }
        .flatMap { it.value.values.toList() }

fun Iterable<Int>.averageOrZero() = average()
    .run {
        if (isNaN()) 0.0 else this
    }
