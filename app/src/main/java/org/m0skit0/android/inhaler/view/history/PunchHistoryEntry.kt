package org.m0skit0.android.inhaler.view.history

import org.m0skit0.android.inhaler.domain.model.Punch
import java.util.*

data class PunchHistoryEntry(val time: Date)

fun Punch.toPunchHistoryEntry() = PunchHistoryEntry(time)
