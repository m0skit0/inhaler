package org.m0skit0.android.inhaler.domain

import org.m0skit0.android.inhaler.data.PunchEntity
import java.util.*

data class Punch(
        val time: Date
)

fun Punch.toEntity() = PunchEntity(time)
