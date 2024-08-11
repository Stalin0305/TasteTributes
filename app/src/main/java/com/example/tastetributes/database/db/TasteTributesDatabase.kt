package com.example.tastetributes.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tastetributes.database.dao.UserDao
import com.example.tastetributes.database.entities.UserInfo

@Database(
    entities = [UserInfo::class],
    version = 1
)
abstract class TasteTributesDatabase : RoomDatabase() {

    abstract fun getUserInfoDao(): UserDao

    companion object {
        private const val DB_NAME = "TasteTribute-Database.db"

        @Volatile
        private var INSTANCE: TasteTributesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                TasteTributesDatabase::class.java,
                DB_NAME,
            )
                .fallbackToDestructiveMigration()
                .build()
                .also {
                    INSTANCE = it
                }
        }
    }
}