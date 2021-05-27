package org.m0skit0.android.inhaler.data.punch

import org.joda.time.DateTime
import org.m0skit0.android.inhaler.data.room.PunchEntity

data class PunchData(val time: DateTime)

fun PunchData.toEntity(inhalerId: Long) = PunchEntity(time.millis, inhalerId)
fun PunchEntity.toData() = PunchData(DateTime(timestamp))
