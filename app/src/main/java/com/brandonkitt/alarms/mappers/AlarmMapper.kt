package com.brandonkitt.alarms.mappers

import com.brandonkitt.alarms.entities.AlarmEntity
import com.brandonkitt.alarms.room.dbo.AlarmDbo
import com.brandonkitt.alarms.utilities.Converter

object AlarmMapper {
    fun toEntity(dbos: List<AlarmDbo>): List<AlarmEntity> {
        return dbos.map { AlarmEntity(
            it.alarmId,
            it.name,
            Converter.stringToDate(it.time),
            Converter.stringToDays(it.days),
            it.enabled
        ) }
    }

    fun toDbo(entities: List<AlarmEntity>): List<AlarmDbo> {
        return entities.map { AlarmDbo(
            it.alarmId,
            it.name,
            Converter.dateToString(it.time),
            Converter.daysToString(it.days),
            it.enabled
        ) }
    }
}