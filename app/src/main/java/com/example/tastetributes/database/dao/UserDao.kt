package com.example.tastetributes.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.tastetributes.database.entities.UserInfo

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserInfo)

    @Delete
    suspend fun removeUser(user: UserInfo)
}