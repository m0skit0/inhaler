package org.m0skit0.android.inhaler.data.model

data class PunchStatisticsData(
    val total: Int,
    val dailyAverage: Double,
    val dailyMaximum: Int,
    val monthlyAverage: Double
)
