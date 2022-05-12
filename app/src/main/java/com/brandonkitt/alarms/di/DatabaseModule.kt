package com.brandonkitt.alarms.di

import android.content.Context
import androidx.room.Room
import com.brandonkitt.alarms.room.RoomDatabase
import com.brandonkitt.alarms.room.dao.AlarmDao
import com.brandonkitt.alarms.utilities.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): RoomDatabase {
        return Room.databaseBuilder(context, RoomDatabase::class.java, DATABASE_NAME).build()
    }

    @Provides
    fun provideAlarmDao(database: RoomDatabase): AlarmDao = database.alarmDao()

}