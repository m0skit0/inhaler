package org.m0skit0.android.inhaler.data

import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.m0skit0.android.inhaler.data.model.PunchData
import org.m0skit0.android.inhaler.data.model.toEntity
import org.m0skit0.android.inhaler.data.punch.PunchRepositoryImpl
import org.m0skit0.android.inhaler.data.room.InhalerDatabase
import org.m0skit0.android.inhaler.data.room.PunchDao
import org.m0skit0.android.inhaler.data.room.PunchEntity
import java.util.*

class TestPunchRepositoryImpl {

    @MockK
    private lateinit var mockDatabase: InhalerDatabase

    @MockK
    private lateinit var mockPunchDao: PunchDao

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
        PunchRepositoryImpl(mockDatabase).run(block)
    }

    @Test
    fun `when call punch should insert into database`() {
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
    fun `when call allPunches should fetch punches from database`() {
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
}
