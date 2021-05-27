package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.daysBetweenOldestAndNow
import org.m0skit0.android.inhaler.data.monthsBetweenOldestAndNow
import org.m0skit0.android.inhaler.data.punch.PunchData
import org.m0skit0.android.inhaler.data.toDayOnly

fun List<PunchData>.dailyAverage(): Double =
    (size / daysBetweenOldestAndNow().toDouble()).nanAsZero()

fun List<PunchData>.monthlyAverage(): Double =
    (size / monthsBetweenOldestAndNow().toDouble()).nanAsZero()

private fun Double.nanAsZero() = if (isNaN()) 0.0 else this

fun List<PunchData>.daysBetweenOldestAndNow(): Int =
    map { it.time.toDayOnly() }.daysBetweenOldestAndNow()

fun List<PunchData>.monthsBetweenOldestAndNow(): Int =
    map { it.time.toDayOnly() }.monthsBetweenOldestAndNow()
