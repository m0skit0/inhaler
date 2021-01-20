package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData
import java.text.SimpleDateFormat
import java.util.*

private val dateFormatter = SimpleDateFormat("dd/MM/yyyy")
val punchDataList = listOf(
    "01/01/2020".toPunchData(),
    "01/01/2020".toPunchData(),
    "01/01/2020".toPunchData(),
    "15/01/2020".toPunchData(),
    "04/02/2020".toPunchData(),
    "07/04/2020".toPunchData(),
    "07/04/2020".toPunchData(),
    "30/08/2020".toPunchData(),
    "12/12/2020".toPunchData(),
)

fun String.toPunchData(): PunchData = PunchData(toDate())

fun String.toDate(): Date = dateFormatter.parse(this)!!

fun PunchData.toList() = listOf(this)
