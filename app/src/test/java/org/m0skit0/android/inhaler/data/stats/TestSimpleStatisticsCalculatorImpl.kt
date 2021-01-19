package org.m0skit0.android.inhaler.data.stats

import org.junit.Test
import org.m0skit0.android.inhaler.data.PunchData
import java.text.SimpleDateFormat

class TestSimpleStatisticsCalculatorImpl {

    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy")

    private val punchDataList = listOf(
        "01/01/2020".toPunchData(),
        "01/01/2020".toPunchData(),
        "01/01/2020".toPunchData(),
        "15/01/2020".toPunchData(),
        "04/02/2020".toPunchData(),
        "07/04/2020".toPunchData(),
        "07/04/2020".toPunchData(),
        "30/08/2020".toPunchData(),
        "12/12/2020".toPunchData(),
    )

    private fun withCalculator(block: SimpleStatisticsCalculatorImpl.() -> Unit) {
        SimpleStatisticsCalculatorImpl().run(block)
    }

    private fun String.toPunchData(): PunchData = dateFormatter.parse(this)!!.let {
        PunchData(it)
    }

    @Test
    fun `when call total on an empty list should return 0`() {
        withCalculator {
            emptyList<PunchData>().total() shouldBe 0
        }
    }

    @Test
    fun `when call total should return total number of elements in the list`() {
        withCalculator {
            punchDataList.total() shouldBe punchDataList.size
        }
    }

    @Test
    fun `when call dailyAverage on an empty list should return 0`() {
        withCalculator {
            emptyList<PunchData>().dailyAverage() shouldBe 0.0
        }
    }

    @Test
    fun `when call dailyAverage on an list should return daily average`() {
        withCalculator {
            punchDataList.dailyAverage() shouldBe 9.0/6.0
        }
    }

    @Test
    fun `when call dailyMaximum on an empty list should return 0`() {
        withCalculator {
            emptyList<PunchData>().dailyMaximum() shouldBe 0
        }
    }

    @Test
    fun `when call dailyMaximum on an list should return 0`() {
        withCalculator {
            punchDataList.dailyMaximum() shouldBe 3
        }
    }

    @Test
    fun `when call monthlyAverage on an empty list should return 0`() {
        withCalculator {
            emptyList<PunchData>().monthlyAverage() shouldBe 0.0
        }
    }

    @Test
    fun `when call monthlyAverage on an list should return 0`() {
        withCalculator {
            punchDataList.monthlyAverage() shouldBe 9.0/5.0
        }
    }
}
