package org.m0skit0.android.inhaler.data.model

import org.joda.time.DateTime
import org.m0skit0.android.inhaler.data.room.PunchEntity

data class PunchData(val time: DateTime)

fun PunchData.toEntity() = PunchEntity(time.millis)
fun PunchEntity.toData() = PunchData(DateTime(timestamp))
