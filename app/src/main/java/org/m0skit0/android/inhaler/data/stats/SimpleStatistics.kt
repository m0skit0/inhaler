package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData
import org.m0skit0.android.inhaler.data.toDayOnly

fun List<PunchData>.total(): Int = size

fun List<PunchData>.dailyMaximum(): Int =
    map { PunchData(it.time.toDayOnly()) }
        .groupBy { it.time }
        .map { it.value.size }
        .maxOfOrNull { it } ?: 0
