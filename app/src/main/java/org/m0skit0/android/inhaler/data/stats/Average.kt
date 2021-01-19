package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData

fun List<PunchData>.dailyAverage(): Double = groupByYearMonthDay().punchesPerDay().averageOrZero()

fun List<PunchData>.monthlyAverage(): Double = groupByYearMonth().punchesPerMonth().averageOrZero()

private fun Iterable<Int>.averageOrZero() = average()
    .run {
        if (isNaN()) 0.0 else this
    }
