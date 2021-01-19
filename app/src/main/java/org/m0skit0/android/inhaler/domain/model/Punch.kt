package org.m0skit0.android.inhaler.domain.model

import org.m0skit0.android.inhaler.data.model.PunchData
import java.util.*

data class Punch(val time: Date)

fun Punch.toData() = PunchData(time)
fun PunchData.toPunch() = Punch(time)
