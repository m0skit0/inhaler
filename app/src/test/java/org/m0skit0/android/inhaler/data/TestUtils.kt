package org.m0skit0.android.inhaler.data

import org.joda.time.DateTime
import org.m0skit0.android.inhaler.data.model.PunchData

val punchDateTimes: List<DateTime> = listOf(
    "01/01/2020".toDateTime(),
    "01/01/2020".toDateTime(),
    "01/01/2020".toDateTime(),
    "03/01/2020".toDateTime(),
    "04/02/2020".toDateTime(),
    "07/02/2020".toDateTime(),
    "07/02/2020".toDateTime(),
    "20/02/2020".toDateTime(),
    "21/02/2020".toDateTime(),
)

val punchDataList: List<PunchData> = punchDateTimes.map { PunchData(it) }
