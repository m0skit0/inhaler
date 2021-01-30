package org.m0skit0.android.inhaler.data

import io.kotlintest.shouldBe
import org.junit.Test
import org.m0skit0.android.inhaler.data.stats.daysBetweenOldestAndNow
import org.m0skit0.android.inhaler.data.stats.punchDataList

class TestDateUtils {

    @Test
    fun `when calling daysBetweenOldestAndNow() should return days between oldest day and current day`() {
        punchDataList.daysBetweenOldestAndNow() shouldBe 51
    }
}
