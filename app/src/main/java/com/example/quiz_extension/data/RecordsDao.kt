package com.example.quiz_extension.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface RecordDao{

    @Query("SELECT * FROM records ORDER BY correct_answers DESC")
    fun getAllRecords() : Flow<List<Record>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(record: Record)
}

