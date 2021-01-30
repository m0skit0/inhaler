package org.m0skit0.android.inhaler.data

import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.Months
import org.joda.time.format.DateTimeFormat
import org.m0skit0.android.inhaler.data.model.PunchData

fun DateTime.toDayOnly(): DateTime = withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0)

fun now(): DateTime = DateTime.now()

fun List<DateTime>.daysBetweenOldestAndNow(): Int {
    val oldest: DateTime = minOrNull()?.let { DateTime(it) } ?: DateTime.now()
    val now = DateTime.now()
    return Days.daysBetween(now, oldest).days
}

fun List<DateTime>.monthsBetweenOldestAndNow(): Int {
    val oldest: DateTime = minOrNull()?.let { DateTime(it) } ?: DateTime.now()
    val now = DateTime.now()
    return Months.monthsBetween(now, oldest).months
}

fun List<DateTime>.generateAllDaysBetweenOldestAndNow(): List<DateTime> {
    if (isEmpty()) return listOf(now())
    val oldest: DateTime = minOrNull() ?: now()
    val days = daysBetweenOldestAndNow()
    return List(days) {
        oldest.plusDays(it)
    }
}

fun String.toPunchData(): PunchData = PunchData(toDateTime())

private val FORMATTER by lazy { DateTimeFormat.forPattern("dd/MM/yyyy") }
fun String.toDateTime(): DateTime = DateTime.parse(this, FORMATTER)
