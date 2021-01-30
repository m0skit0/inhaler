package org.m0skit0.android.inhaler.data.stats

import org.joda.time.DateTime
import org.m0skit0.android.inhaler.data.daysBetweenOldestAndNow
import org.m0skit0.android.inhaler.data.model.PunchData
import org.m0skit0.android.inhaler.data.now
import org.m0skit0.android.inhaler.data.toDayOnly

//fun List<PunchData>.punchesPerDay(): Map<DateTime, Int> {
//    val groupedByDay = groupByDay()
//
//}

private fun List<PunchData>.groupByDay(): Map<DateTime, Int> =
    map { PunchData(it.time.toDayOnly()) }.groupBy { it.time }.mapValues { it.value.size }

fun List<DateTime>.generateAllDaysBetweenOldestAndNow(): List<DateTime> {
    val oldest: DateTime = if (isEmpty()) now() else minOf { it.millis }.let { DateTime(it) }
    val days = daysBetweenOldestAndNow()
    return List(days) {
        oldest.plusDays(0)
    }
}
