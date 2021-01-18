package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.PunchData

interface StatisticsCalculator {
    fun List<PunchData>.total(): Int
    fun List<PunchData>.dailyAverage(): Double
    fun List<PunchData>.dailyMaximum(): Int
    fun List<PunchData>.monthlyAverage(): Double
}
