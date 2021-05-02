package org.m0skit0.android.inhaler.view.punchdetails

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.joda.time.DateTime
import org.m0skit0.android.inhaler.domain.punch.Punch
import org.m0skit0.android.inhaler.view.history.PunchHistoryEntry

@Parcelize
data class PunchDetails(val time: DateTime) : Parcelable

fun PunchHistoryEntry.toPunchDetails(): PunchDetails = PunchDetails(time)
fun PunchDetails.toPunch() = Punch(time)
