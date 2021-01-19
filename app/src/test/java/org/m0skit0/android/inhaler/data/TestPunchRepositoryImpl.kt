package org.m0skit0.android.inhaler.data

import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.m0skit0.android.inhaler.data.punch.PunchRepositoryImpl
import org.m0skit0.android.inhaler.data.room.InhalerDatabase
import org.m0skit0.android.inhaler.data.room.PunchDao
import org.m0skit0.android.inhaler.data.room.PunchEntity
import org.m0skit0.android.inhaler.data.stats.SimpleStatisticsCalculator
import java.util.*

class TestPunchRepositoryImpl {

    @MockK
    private lateinit var mockDatabase: InhalerDatabase

    @MockK
    private lateinit var mockPunchDao: PunchDao

    @MockK
    private lateinit var mockSimpleStatisticsCalculator: SimpleStatisticsCalculator

    private val punchData = PunchData(Date())

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        mockFunctions()
    }

    private fun mockFunctions() {
        every { mockDatabase.punchDao() } returns mockPunchDao
    }

    private fun withRepository(block: PunchRepositoryImpl.() -> Unit) {
        PunchRepositoryImpl(mockDatabase, mockSimpleStatisticsCalculator).run(block)
    }

    @Test
    fun `when punch should insert into database`() {
        coEvery { mockPunchDao.insert(any()) } just Runs
        withRepository {
            runBlocking {
                punch(punchData)
            }
        }
        coVerify {
            mockPunchDao.insert(punchData.toEntity())
        }
    }

    @Test
    fun `when allPunches should fetch punches from database`() {
        every { mockPunchDao.all() } returns flow { emit(emptyList<PunchEntity>()) }
        withRepository {
            runBlocking {
                allPunches().collect()
            }
        }
        verify {
            mockPunchDao.all()
        }
    }

    @Test
    fun `when statistics should calculate statistics`() {
        every { mockPunchDao.all() } returns flow { emit(emptyList<PunchEntity>()) }
        every { mockSimpleStatisticsCalculator.run { any<List<PunchData>>().total() } } returns 0
        every { mockSimpleStatisticsCalculator.run { any<List<PunchData>>().dailyAverage() } } returns 0.0
        every { mockSimpleStatisticsCalculator.run { any<List<PunchData>>().dailyMaximum() } } returns 0
        every { mockSimpleStatisticsCalculator.run { any<List<PunchData>>().monthlyAverage() } } returns 0.0
        withRepository {
            runBlocking {
                statistics().collect()
            }
        }
        verify {
            mockSimpleStatisticsCalculator.run {
                emptyList<PunchData>().total()
                emptyList<PunchData>().dailyAverage()
                emptyList<PunchData>().dailyMaximum()
                emptyList<PunchData>().monthlyAverage()
            }
        }
    }
}
