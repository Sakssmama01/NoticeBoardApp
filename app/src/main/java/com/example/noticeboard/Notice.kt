package com.example.noticeboard

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notice_table")
data class Notice(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String
)
