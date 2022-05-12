package com.brandonkitt.alarms.room.dbo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarms")
data class AlarmDbo(
    @PrimaryKey @ColumnInfo(name = "id") val alarmId: String,
    val name: String,
    val time: String,
    val days: String,
    val enabled: Boolean
)