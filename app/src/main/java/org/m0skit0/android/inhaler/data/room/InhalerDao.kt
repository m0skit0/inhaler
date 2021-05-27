package org.m0skit0.android.inhaler.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface InhalerDao {

    @Query("SELECT * FROM inhaler ORDER BY startTimestamp DESC")
    fun all(): Flow<List<InhalerEntity>>

    @Query("SELECT COUNT(0) FROM punch WHERE inhaler = :inhalerEntityId")
    fun punchesCount(inhalerEntityId: Long): Int

    @Query("SELECT * FROM inhaler ORDER BY startTimestamp DESC LIMIT 1")
    fun current(): InhalerEntity

    @Insert
    suspend fun insert(vararg inhalerEntity: InhalerEntity)

    @Delete
    suspend fun delete(vararg inhalerEntity: InhalerEntity)
}
