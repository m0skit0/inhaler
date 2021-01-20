package org.m0skit0.android.inhaler.data.stats

import io.kotlintest.shouldBe
import org.junit.Test
import org.m0skit0.android.inhaler.data.model.PunchData

class TestSimpleStatistics {

    @Test
    fun `when call total on an empty list should return 0`() {
        emptyList<PunchData>().total() shouldBe 0
    }

    @Test
    fun `when call total should return total number of elements in the list`() {
        punchDataList.total() shouldBe punchDataList.size
    }

    @Test
    fun `when call dailyMaximum on an empty list should return 0`() {
        emptyList<PunchData>().dailyMaximum() shouldBe 0
    }

    @Test
    fun `when call dailyMaximum on an list should return 3`() {
        punchDataList.dailyMaximum() shouldBe 3
    }
}
