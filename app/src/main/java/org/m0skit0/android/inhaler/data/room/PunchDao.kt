package org.m0skit0.android.inhaler.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PunchDao {

    @Query("SELECT * FROM punch ORDER BY timestamp DESC")
    fun all(): Flow<List<PunchEntity>>

    @Insert
    suspend fun insert(vararg punchEntity: PunchEntity)

    @Delete
    suspend fun delete(vararg punchEntity: PunchEntity)
}
