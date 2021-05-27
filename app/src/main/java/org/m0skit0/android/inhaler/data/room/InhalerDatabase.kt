package org.m0skit0.android.inhaler.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

private const val VERSION = 2

@Database(entities = [PunchEntity::class, InhalerEntity::class], version = VERSION)
abstract class InhalerDatabase : RoomDatabase() {

    companion object {
        const val NAME = "database"
    }

    abstract fun punchDao(): PunchDao
}
