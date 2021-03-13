package org.m0skit0.android.inhaler.view.punchedit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.joda.time.DateTime
import org.m0skit0.android.inhaler.domain.model.Punch
import org.m0skit0.android.inhaler.view.punchdetails.PunchDetails

@Parcelize
data class PunchEditDetails(val time: DateTime) : Parcelable

fun PunchDetails.toPunchEditDetails(): PunchEditDetails = PunchEditDetails(time)
fun PunchEditDetails.toPunch() = Punch(time)
