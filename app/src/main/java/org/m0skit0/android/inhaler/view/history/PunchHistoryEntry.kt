package org.m0skit0.android.inhaler.view.history

import org.joda.time.DateTime
import org.m0skit0.android.inhaler.domain.model.Punch

data class PunchHistoryEntry(val time: DateTime)

fun Punch.toPunchHistoryEntry() = PunchHistoryEntry(time)
fun PunchHistoryEntry.toPunch() = Punch(time)
