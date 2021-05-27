package org.m0skit0.android.inhaler.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inhaler")
data class InhalerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val startTimestamp: Long
)
