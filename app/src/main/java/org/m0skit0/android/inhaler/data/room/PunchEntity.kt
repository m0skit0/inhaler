package org.m0skit0.android.inhaler.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.m0skit0.android.inhaler.data.PunchData

@Entity(tableName = "punch")
data class PunchEntity(
        @PrimaryKey
        val timestamp: Long
)

fun PunchData.toEntity() = PunchEntity(time.time)