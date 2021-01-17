package org.m0skit0.android.inhaler.data

import org.m0skit0.android.inhaler.data.room.PunchEntity
import java.util.*

data class PunchData(val time: Date)

fun PunchData.toEntity() = PunchEntity(time.time)
fun PunchEntity.toData() = PunchData(Date(timestamp))
