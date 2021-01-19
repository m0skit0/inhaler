package org.m0skit0.android.inhaler.data

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import io.mockk.verify
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.m0skit0.android.inhaler.data.model.PunchData
import org.m0skit0.android.inhaler.data.punch.PunchRepository
import org.m0skit0.android.inhaler.data.punch.StatisticsRepository
import org.m0skit0.android.inhaler.data.punch.StatisticsRepositoryImpl
import org.m0skit0.android.inhaler.data.stats.dailyAverage
import org.m0skit0.android.inhaler.data.stats.dailyMaximum
import org.m0skit0.android.inhaler.data.stats.monthlyAverage
import org.m0skit0.android.inhaler.data.stats.total

class TestStatisticsRepositoryImpl {

    @MockK
    private lateinit var mockPunchRepository: PunchRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    private fun withRepository(block: StatisticsRepository.() -> Unit) {
        StatisticsRepositoryImpl(mockPunchRepository).run(block)
    }

    @Test
    fun `when statistics should calculate statistics`() {
        every { mockPunchRepository.allPunches() } returns flow { emit(emptyList<PunchData>()) }
        mockkStatic("org.m0skit0.android.inhaler.data.stats.SimpleStatisticsKt")
        every { any<List<PunchData>>().total() } returns 0
        every { any<List<PunchData>>().dailyMaximum() } returns 0
        mockkStatic("org.m0skit0.android.inhaler.data.stats.AverageKt")
        every { any<List<PunchData>>().dailyAverage() } returns 0.0
        every { any<List<PunchData>>().monthlyAverage() } returns 0.0
        withRepository {
            runBlocking {
                statistics().collect()
            }
        }
        verify {
            emptyList<PunchData>().total()
            emptyList<PunchData>().dailyMaximum()
            emptyList<PunchData>().dailyAverage()
            emptyList<PunchData>().monthlyAverage()
        }
    }
}
