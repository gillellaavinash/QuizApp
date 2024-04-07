package com.example.quiz_extension.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "records")
data class Record(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "user_name")
    val name: String,
    @ColumnInfo(name = "correct_answers")
    val correctAnswers: Int
)