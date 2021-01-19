package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData

interface SimpleStatisticsCalculator {
    fun List<PunchData>.total(): Int
    fun List<PunchData>.dailyMaximum(): Int
}
