package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData

fun List<PunchData>.total(): Int = size

fun List<PunchData>.dailyMaximum(): Int =
    groupByYearMonthDay().punchesPerDay().maxByOrNull { it } ?: 0
