package com.example.tastetributes.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = -1,
    val email: String,
    val uuid: String,
    val userName: String
)
