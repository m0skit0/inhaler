package org.m0skit0.android.inhaler.data.stats

import io.kotlintest.shouldBe
import org.junit.Test
import org.m0skit0.android.inhaler.data.model.PunchData
import java.util.*

class TestGroup {

    @Test
    fun `when call groupByYearMonthDay on empty list should return empty map`() {
        emptyList<PunchData>().groupByYearMonthDay() shouldBe emptyMap()
    }

    @Test
    fun `when call groupByYearMonthDay should group by year month and day`() {
        punchDataList.groupByYearMonthDay() shouldBe
                mapOf(
                    2020 to mapOf(
                        Calendar.JANUARY to mapOf(
                            1 to punchDataList.subList(0, 3),
                            15 to punchDataList[3].toList(),
                        ),
                        Calendar.FEBRUARY to mapOf(
                            4 to punchDataList[4].toList()
                        ),
                        Calendar.APRIL to mapOf(
                            7 to punchDataList.subList(5, 7)
                        ),
                        Calendar.AUGUST to mapOf(
                            30 to punchDataList[7].toList()
                        ),
                        Calendar.DECEMBER to mapOf(
                            12 to punchDataList[8].toList()
                        ),
                    )
                )
    }

    @Test
    fun `when call groupByYearMonth should group by year and month`() {
        punchDataList.groupByYearMonth() shouldBe
                mapOf(
                    2020 to mapOf(
                        Calendar.JANUARY to punchDataList.subList(0, 4),
                        Calendar.FEBRUARY to punchDataList[4].toList(),
                        Calendar.APRIL to punchDataList.subList(5, 7),
                        Calendar.AUGUST to punchDataList[7].toList(),
                        Calendar.DECEMBER to punchDataList[8].toList()
                    )
                )
    }

    @Test
    fun `when call punchesPerDay should return list of punches per day`() {
        punchDataList.groupByYearMonthDay().punchesPerDay() shouldBe
                listOf(3, 1, 1, 2, 1, 1)
    }

    @Test
    fun `when call punchesPerMonth should return list of punches per month`() {
        punchDataList.groupByYearMonth().punchesPerMonth() shouldBe
                listOf(4, 1, 2, 1, 1)
    }

    @Test
    fun `when call groupByDay should return punches grouped by day`() {
        punchDataList.groupByDay() shouldBe mapOf(
            "01/01/2020".toDate() to 3,
            "15/01/2020".toDate() to 1,
            "04/02/2020".toDate() to 1,
            "07/04/2020".toDate() to 2,
            "30/08/2020".toDate() to 1,
            "12/12/2020".toDate() to 1,
        )
    }
}
