package com.brandonkitt.alarms.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.brandonkitt.alarms.room.dao.AlarmDao
import com.brandonkitt.alarms.room.dbo.AlarmDbo
import com.brandonkitt.alarms.utilities.DATABASE_NAME

/**
 * The Room database for this app
 */
@Database(entities = [AlarmDbo::class], version = 1, exportSchema = false)
abstract class RoomDatabase : androidx.room.RoomDatabase() {

    abstract fun alarmDao(): AlarmDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: RoomDatabase? = null

        fun getInstance(context: Context): RoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): RoomDatabase {
            return Room.databaseBuilder(context, RoomDatabase::class.java, DATABASE_NAME).build()
        }
    }
}