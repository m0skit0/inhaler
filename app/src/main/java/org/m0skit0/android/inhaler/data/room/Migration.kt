package org.m0skit0.android.inhaler.data.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        with (database) {
            execSQL("ALTER TABLE punch ADD COLUMN inhaler INTEGER")
            execSQL("CREATE TABLE IF NOT EXISTS inhaler (id INTEGER, startTimestamp INTEGER, PRIMARY KEY(id))")
        }
    }
}
