package org.m0skit0.android.inhaler.data.stats

import io.kotlintest.shouldBe
import org.junit.Test
import org.m0skit0.android.inhaler.data.model.PunchData
import java.text.SimpleDateFormat

class TestSimpleStatistics {

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

    private fun String.toPunchData(): PunchData = dateFormatter.parse(this)!!.let {
        PunchData(it)
    }

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
