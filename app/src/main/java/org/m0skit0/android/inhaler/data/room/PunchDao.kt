package org.m0skit0.android.inhaler.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PunchDao {

    @Query("SELECT * FROM punch")
    fun all(): List<PunchEntity>

    @Insert
    fun insert(vararg punchEntity: PunchEntity)
}