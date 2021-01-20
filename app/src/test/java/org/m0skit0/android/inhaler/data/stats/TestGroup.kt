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
}
