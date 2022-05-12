package com.brandonkitt.alarms.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.brandonkitt.alarms.room.dbo.AlarmDbo

@Dao
interface AlarmDao {
    @Query("SELECT * FROM alarms")
    fun getAlarms(): LiveData<List<AlarmDbo>>

    @Query("SELECT * FROM alarms WHERE id = :alarmId")
    fun getAlarm(alarmId: String): LiveData<AlarmDbo>

    @Insert
    suspend fun insertAlarm(alarmDbo: AlarmDbo): Long

    @Delete
    suspend fun deleteAlarm(alarmDbo: AlarmDbo)

    @Update
    suspend fun updateAlarm(alarmDbo: AlarmDbo)
}