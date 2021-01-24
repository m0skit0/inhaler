package org.m0skit0.android.inhaler.data.stats

import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.Months
import org.m0skit0.android.inhaler.data.model.PunchData

fun List<PunchData>.dailyAverage(): Double =
    (size / daysBetweenOldestAndNow().toDouble()).nanAsZero()

fun List<PunchData>.monthlyAverage(): Double =
    (size / monthsBetweenOldestAndNow().toDouble()).nanAsZero()

private fun Double.nanAsZero() = if (isNaN()) 0.0 else this

private fun List<PunchData>.daysBetweenOldestAndNow(): Int {
    val oldest: DateTime = map { it.time }.minOrNull()?.let { DateTime(it) } ?: DateTime.now()
    val now = DateTime.now()
    return Days.daysBetween(now, oldest).days
}

private fun List<PunchData>.monthsBetweenOldestAndNow(): Int {
    val oldest: DateTime = map { it.time }.minOrNull()?.let { DateTime(it) } ?: DateTime.now()
    val now = DateTime.now()
    return Months.monthsBetween(now, oldest).months
}
