package org.m0skit0.android.inhaler.data

import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.Months
import org.joda.time.format.DateTimeFormat
import org.m0skit0.android.inhaler.data.model.PunchData

fun DateTime.toDayOnly(): DateTime =
    withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0)

fun now(): DateTime = DateTime.now()

infix fun List<DateTime>.daysBetweenOldestAnd(time: DateTime): Int {
    val oldest: DateTime = minOrNull()?.let { DateTime(it) } ?: DateTime.now()
    return Days.daysBetween(oldest, time).days
}

fun List<DateTime>.daysBetweenOldestAndNow(): Int = this daysBetweenOldestAnd now()

infix fun List<DateTime>.monthsBetweenOldestAnd(time: DateTime): Int {
    val oldest: DateTime = minOrNull()?.let { DateTime(it) } ?: DateTime.now()
    return Months.monthsBetween(oldest, time).months
}

fun List<DateTime>.monthsBetweenOldestAndNow(): Int = this monthsBetweenOldestAnd now()

infix fun List<DateTime>.generateAllDaysBetweenOldestAnd(time: DateTime): List<DateTime> {
    val dayOnly = time.toDayOnly()
    if (isEmpty()) return listOf(dayOnly)
    val oldest: DateTime = minOrNull() ?: dayOnly
    val days = this daysBetweenOldestAnd dayOnly
    return List(days + 1) {
        oldest.plusDays(it)
    }
}

fun List<DateTime>.generateAllDaysBetweenOldestAndNow(): List<DateTime> =
    this generateAllDaysBetweenOldestAnd now()

fun String.toPunchData(): PunchData = PunchData(toDateTime())

private val FORMATTER by lazy { DateTimeFormat.forPattern("dd/MM/yyyy") }
fun String.toDateTime(): DateTime = DateTime.parse(this, FORMATTER)
