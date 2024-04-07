package com.example.quiz_extension.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Record::class],
    version = 1,
    exportSchema = false
)
abstract class RecordDatabase : RoomDatabase() {
    abstract fun recordDao(): RecordDao
}