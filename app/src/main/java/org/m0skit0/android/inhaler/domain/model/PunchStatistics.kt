package org.m0skit0.android.inhaler.domain.model

import org.m0skit0.android.inhaler.data.model.PunchStatisticsData

data class PunchStatistics(
    val total: Int,
    val dailyAverage: Double,
    val dailyMaximum: Int,
    val monthlyAverage: Double
)

fun PunchStatisticsData.toPunchStatistics(): PunchStatistics =
    PunchStatistics(total, dailyAverage, dailyMaximum, monthlyAverage)
