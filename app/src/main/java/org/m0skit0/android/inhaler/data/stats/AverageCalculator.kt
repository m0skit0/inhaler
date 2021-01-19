package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData

interface AverageCalculator {
    fun List<PunchData>.dailyAverage(): Double
    fun List<PunchData>.monthlyAverage(): Double
}
