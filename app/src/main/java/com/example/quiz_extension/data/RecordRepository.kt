package com.example.quiz_extension.data

import kotlinx.coroutines.flow.Flow


class RecordRepository(private val recordDao: RecordDao) {

    val getRecords : Flow<List<Record>> = recordDao.getAllRecords()


    suspend fun insertRecords(record: Record) {
        recordDao.insertRecord(record)
    }
}