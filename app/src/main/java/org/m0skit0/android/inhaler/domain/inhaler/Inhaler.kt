package org.m0skit0.android.inhaler.domain.inhaler

import org.joda.time.DateTime
import org.m0skit0.android.inhaler.data.inhaler.InhalerData

data class Inhaler(
    val id: Long,
    val startTime: DateTime
)

fun Inhaler.toData(): InhalerData = InhalerData(id, startTime)
fun InhalerData.toInhaler(): Inhaler = Inhaler(id, startTime)
