package org.m0skit0.android.inhaler.view.stats

import org.m0skit0.android.inhaler.domain.model.PunchStatistics

data class PunchStatisticsView(
    val total: Int,
    val dailyAverage: Double,
    val dailyMaximum: Int,
    val monthlyAverage: Double
)

fun PunchStatistics.toPunchStatisticsView() =
    PunchStatisticsView(total, dailyAverage, dailyMaximum, monthlyAverage)
