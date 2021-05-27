package org.m0skit0.android.inhaler.data.mock

import org.m0skit0.android.inhaler.data.inhaler.InhalerData
import org.m0skit0.android.inhaler.data.punch.PunchData
import org.m0skit0.android.inhaler.data.toDateTime
import javax.inject.Inject
import kotlin.random.Random

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

    val inhalerDataList = listOf(
        "01/01/2020".toInhalerData(),
        "03/02/2020".toInhalerData(),
    )
}

fun String.toPunchData(): PunchData = PunchData(toDateTime())
fun String.toInhalerData(): InhalerData = InhalerData(Random.nextLong(), toDateTime())
