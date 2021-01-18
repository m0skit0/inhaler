package org.m0skit0.android.inhaler.view.stats

data class PunchStatisticsView(
    val total: Int,
    val dailyAverage: Double,
    val dailyMaximum: Int,
    val monthlyAverage: Double
)
