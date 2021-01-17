package org.m0skit0.android.inhaler.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

private const val VERSION = 1

@Database(entities = [PunchEntity::class], version = VERSION)
abstract class Database : RoomDatabase() {
    abstract fun punchDao(): PunchDao
}