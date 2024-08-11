package com.example.tastetributes.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.tastetributes.database.entities.UserInfo

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user: UserInfo)

    @Delete
    suspend fun removeUser(user: UserInfo)
}