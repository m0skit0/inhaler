package org.m0skit0.android.inhaler.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PunchDao {

    @Query("SELECT * FROM punch ORDER BY timestamp DESC")
    suspend fun all(): List<PunchEntity>

    @Insert
    suspend fun insert(vararg punchEntity: PunchEntity)
}
