package com.brandonkitt.alarms.entities

import com.brandonkitt.alarms.enums.DayOfWeek
import java.util.*

data class AlarmEntity(
    val alarmId: String,
    val name: String,
    val time: Date,
    val days: List<DayOfWeek>,
    val enabled: Boolean
)