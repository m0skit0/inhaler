package org.m0skit0.android.inhaler.data

import io.kotlintest.shouldBe
import org.joda.time.DateTime
import org.junit.Test
import org.m0skit0.android.inhaler.data.model.PunchData
import org.m0skit0.android.inhaler.data.stats.monthsBetweenOldestAndNow

class TestDateUtils {

    @Test
    fun `when calling daysBetweenOldestAndNow on an empty list should return 0`() {
        emptyList<DateTime>().daysBetweenOldestAndNow() shouldBe 0
    }

    @Test
    fun `when calling daysBetweenOldestAnd 2 days after should return 2`() {
        punchDateTimes daysBetweenOldestAnd "03/01/2020".toDateTime() shouldBe 2
    }

    @Test
    fun `when calling daysBetweenOldestAnd 1 month after should return 31`() {
        punchDateTimes daysBetweenOldestAnd "01/02/2020".toDateTime() shouldBe 31
    }

    @Test
    fun `when calling daysBetweenOldestAnd 1 year after should return 366 on leap years`() {
        punchDateTimes daysBetweenOldestAnd "01/01/2021".toDateTime() shouldBe 366
    }

    @Test
    fun `when calling monthsBetweenOldestAndNow on an empty list should return 0`() {
        emptyList<PunchData>().monthsBetweenOldestAndNow() shouldBe 0
    }

    @Test
    fun `when calling monthsBetweenOldestAnd 2 days after should return 0`() {
        punchDateTimes monthsBetweenOldestAnd "03/01/2020".toDateTime() shouldBe 0
    }

    @Test
    fun `when calling monthsBetweenOldestAnd 1 month after should return 1`() {
        punchDateTimes monthsBetweenOldestAnd "01/02/2020".toDateTime() shouldBe 1
    }

    @Test
    fun `when calling monthsBetweenOldestAnd 1 year after should return 12`() {
        punchDateTimes monthsBetweenOldestAnd "01/01/2021".toDateTime() shouldBe 12
    }

    @Test
    fun `when calling generateAllDaysBetweenOldestAndNow on an empty list should return list of today`() {
        emptyList<DateTime>().generateAllDaysBetweenOldestAndNow() shouldBe listOf(now().toDayOnly())
    }

    @Test
    fun `when calling generateAllDaysBetweenOldestAnd 2 days after should return list of 3 days`() {
        punchDateTimes generateAllDaysBetweenOldestAnd "03/01/2020".toDateTime() shouldBe
                listOf(
                    "01/01/2020".toDateTime(),
                    "02/01/2020".toDateTime(),
                    "03/01/2020".toDateTime(),
                )
    }
}
