package org.m0skit0.android.inhaler.domain.model

data class PunchStatistics(
    val total: Int,
    val dailyAverage: Double,
    val dailyMaximum: Int,
    val monthlyAverage: Double
)
