package com.example.memoapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class Memo(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val date: String
)