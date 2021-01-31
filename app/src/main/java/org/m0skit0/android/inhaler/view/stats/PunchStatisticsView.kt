package org.m0skit0.android.inhaler.view.stats

import org.m0skit0.android.inhaler.domain.model.PunchStatistics
import java.text.DecimalFormat

data class PunchStatisticsView(
    val total: String,
    val dailyAverage: String,
    val dailyMaximum: String,
    val monthlyAverage: String
)

fun PunchStatistics.toPunchStatisticsView() =
    PunchStatisticsView(
        total.toString(),
        dailyAverage.toText(),
        dailyMaximum.toString(),
        monthlyAverage.toText()
    )

private fun Double.toText(): String = DecimalFormat.getNumberInstance().format(this)
