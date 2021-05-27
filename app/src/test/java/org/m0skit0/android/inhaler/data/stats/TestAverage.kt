package org.m0skit0.android.inhaler.data.stats

import io.kotlintest.shouldBe
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.Days
import org.joda.time.Months
import org.junit.Test
import org.m0skit0.android.inhaler.data.punch.PunchData
import org.m0skit0.android.inhaler.data.punchDataList

class TestAverage {

    @Test
    fun `when call dailyAverage on an empty list should return 0`() {
        emptyList<PunchData>().dailyAverage() shouldBe 0.0
    }

    @Test
    fun `when call dailyAverage on an list should return daily average`() {
        val oldestPunch = DateTime(punchDataList[0].time, DateTimeZone.UTC)
        val now = DateTime.now()
        punchDataList.dailyAverage() shouldBe punchDataList.size.toDouble() / Days.daysBetween(
            oldestPunch,
            now,
        ).days
    }

    @Test
    fun `when call monthlyAverage on an empty list should return 0`() {
        emptyList<PunchData>().monthlyAverage() shouldBe 0.0
    }

    @Test
    fun `when call monthlyAverage on an list should return monthly average`() {
        val oldestPunch = DateTime(punchDataList[0].time, DateTimeZone.UTC)
        val now = DateTime.now()
        punchDataList.monthlyAverage() shouldBe punchDataList.size.toDouble() / Months.monthsBetween(
            oldestPunch,
            now,
        ).months
    }
}
