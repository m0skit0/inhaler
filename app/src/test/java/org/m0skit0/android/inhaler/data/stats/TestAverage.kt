package org.m0skit0.android.inhaler.data.stats

import io.kotlintest.shouldBe
import org.junit.Test
import org.m0skit0.android.inhaler.data.model.PunchData

class TestAverage {

    @Test
    fun `when call dailyAverage on an empty list should return 0`() {
        emptyList<PunchData>().dailyAverage() shouldBe 0.0
    }

    @Test
    fun `when call dailyAverage on an list should return daily average`() {
        punchDataList.dailyAverage() shouldBe 9.0 / 6.0
    }

    @Test
    fun `when call monthlyAverage on an empty list should return 0`() {
        emptyList<PunchData>().monthlyAverage() shouldBe 0.0
    }

    @Test
    fun `when call monthlyAverage on an list should return monthly average`() {
        punchDataList.monthlyAverage() shouldBe 9.0 / 5.0
    }
}
