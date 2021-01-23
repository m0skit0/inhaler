package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData
import java.text.SimpleDateFormat
import java.util.*

private val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.US)
val punchDataList = listOf(
    "01/01/2020".toPunchData(),
    "01/01/2020".toPunchData(),
    "01/01/2020".toPunchData(),
    "03/01/2020".toPunchData(),
    "04/02/2020".toPunchData(),
    "07/02/2020".toPunchData(),
    "07/02/2020".toPunchData(),
    "20/02/2020".toPunchData(),
    "21/02/2020".toPunchData(),
)

fun String.toPunchData(): PunchData = PunchData(toDate())

fun String.toDate(): Date = dateFormatter.parse(this)!!

fun PunchData.toList() = listOf(this)
