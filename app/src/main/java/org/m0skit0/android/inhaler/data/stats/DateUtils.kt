package org.m0skit0.android.inhaler.data.stats

import java.util.*

fun Date.toDayOnly(): Date = Calendar.getInstance().apply {
    time = this@toDayOnly
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
}.time

fun Date.toCalendar(): Calendar = Calendar.getInstance().apply {
    time = this@toCalendar
}
