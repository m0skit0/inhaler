package org.m0skit0.android.inhaler.data.stats

import org.m0skit0.android.inhaler.data.model.PunchData
import javax.inject.Inject

class AverageCalculatorImpl @Inject constructor() : AverageCalculator {

    override fun List<PunchData>.dailyAverage(): Double = groupByYearMonthDay().punchesPerDay().averageOrZero()

    override fun List<PunchData>.monthlyAverage(): Double = groupByYearMonth().punchesPerMonth().averageOrZero()
}
