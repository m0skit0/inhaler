package org.m0skit0.android.inhaler.data

data class PunchStatisticsData(
    val total: Int,
    val dailyAverage: Double,
    val dailyMaximum: Int,
    val monthlyAverage: Double
)
