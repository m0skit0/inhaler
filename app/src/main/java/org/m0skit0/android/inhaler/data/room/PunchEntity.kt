package org.m0skit0.android.inhaler.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "punch")
data class PunchEntity(
        @PrimaryKey
        val timestamp: Long
)
