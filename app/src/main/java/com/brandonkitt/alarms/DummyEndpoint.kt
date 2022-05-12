package com.brandonkitt.alarms

import com.brandonkitt.alarms.entities.AlarmEntity
import com.brandonkitt.alarms.enums.DayOfWeek
import java.util.*
import javax.inject.Inject

class DummyEndpoint @Inject constructor() {

    fun getAlarms(): List<AlarmEntity> {
        return listOf(
            AlarmEntity(UUID.randomUUID().toString(), "Alarm 1", Date(), listOf(DayOfWeek.MONDAY, DayOfWeek.TUESDAY), false),
            AlarmEntity(UUID.randomUUID().toString(), "Alarm 2", Date(), listOf(DayOfWeek.MONDAY, DayOfWeek.TUESDAY), false),
            AlarmEntity(UUID.randomUUID().toString(), "Alarm 3", Date(), listOf(DayOfWeek.MONDAY, DayOfWeek.TUESDAY), false),
            AlarmEntity(UUID.randomUUID().toString(), "Alarm 4", Date(), listOf(DayOfWeek.MONDAY, DayOfWeek.TUESDAY), false),
        )
    }

}