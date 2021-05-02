package org.m0skit0.android.inhaler.domain.punch

import org.joda.time.DateTime
import org.m0skit0.android.inhaler.data.model.PunchData

data class Punch(val time: DateTime)

fun Punch.toData() = PunchData(time)
fun PunchData.toPunch() = Punch(time)
