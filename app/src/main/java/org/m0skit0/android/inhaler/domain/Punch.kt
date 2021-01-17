package org.m0skit0.android.inhaler.domain

import org.m0skit0.android.inhaler.data.PunchData
import java.util.*

data class Punch(val time: Date)

fun Punch.toData() = PunchData(time)
