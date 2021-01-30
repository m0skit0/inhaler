package org.m0skit0.android.inhaler.data.mock

import org.m0skit0.android.inhaler.data.toPunchData
import javax.inject.Inject

class MockData @Inject constructor() {

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
}
