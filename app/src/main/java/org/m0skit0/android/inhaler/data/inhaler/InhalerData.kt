package org.m0skit0.android.inhaler.data.inhaler

import org.joda.time.DateTime
import org.m0skit0.android.inhaler.data.room.InhalerEntity

data class InhalerData(
    val id: Long,
    val startTime: DateTime
)

fun InhalerEntity.toData(): InhalerData = InhalerData(id, DateTime(startTimestamp))
fun InhalerData.toEntity(): InhalerEntity = InhalerEntity(id, startTime.millis)
