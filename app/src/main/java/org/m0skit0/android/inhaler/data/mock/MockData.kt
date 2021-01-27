package org.m0skit0.android.inhaler.data.mock

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.m0skit0.android.inhaler.data.model.PunchData
import javax.inject.Inject

class MockData @Inject constructor() {

    private val formatter by lazy { DateTimeFormat.forPattern("dd/MM/yyyy") }

    val punchDataList = listOf(
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

    private fun String.toPunchData(): PunchData = PunchData(toDateTime())

    private fun String.toDateTime(): DateTime = DateTime.parse(this, formatter)
}
