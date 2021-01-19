package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData
import javax.inject.Inject

class SimpleStatisticsCalculatorImpl @Inject constructor() : SimpleStatisticsCalculator {

    override fun List<PunchData>.total(): Int = size

    override fun List<PunchData>.dailyMaximum(): Int =
        groupByYearMonthDay().punchesPerDay().maxByOrNull { it } ?: 0
}
