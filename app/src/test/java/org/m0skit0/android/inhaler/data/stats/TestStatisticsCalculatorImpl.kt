package org.m0skit0.android.inhaler.data.stats

import io.kotlintest.shouldBe
import org.junit.Test
import org.m0skit0.android.inhaler.data.PunchData
import java.text.SimpleDateFormat

class TestStatisticsCalculatorImpl {

    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy")

    private val punchDataList = listOf(
        "01/01/2020".toPunchData(),
        "01/01/2020".toPunchData(),
        "01/01/2020".toPunchData(),
        "15/01/2020".toPunchData(),
        "04/02/2020".toPunchData(),
        "07/04/2020".toPunchData(),
    )

    private fun onCalculator(block: StatisticsCalculatorImpl.() -> Unit) {
        StatisticsCalculatorImpl().run(block)
    }

    private fun String.toPunchData(): PunchData = dateFormatter.parse(this)!!.let {
        PunchData(it)
    }

    @Test
    fun `when call total on an empty list should return 0`() {
        onCalculator {
            emptyList<PunchData>().total() shouldBe 0
        }
    }

    @Test
    fun `when call total should return total number of elements in the list`() {
        onCalculator {
            punchDataList.total() shouldBe 6
        }
    }

    @Test
    fun `when call dailyAverage on an empty list should return 0`() {
        onCalculator {
            emptyList<PunchData>().dailyAverage() shouldBe 0.0
        }
    }

    @Test
    fun `when call dailyAverage on an list should return 0`() {
        onCalculator {
            punchDataList.dailyAverage() shouldBe 1.5
        }
    }
}
