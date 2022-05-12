package com.brandonkitt.alarms.utilities

import com.brandonkitt.alarms.enums.DayOfWeek
import java.util.*

object Converter {

    fun stringToDate(date: String): Date {
        val (hour, minute) = date.split(":")
        return Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour.toInt())
            set(Calendar.MINUTE, minute.toInt())
        }.time
    }

    fun dateToString(date: Date): String {
        val calendar = Calendar.getInstance().apply { time = date }
        val hour = calendar.get(Calendar.HOUR_OF_DAY).toString()
        val minute = calendar.get(Calendar.MINUTE).toString()
        return "$hour:$minute"
    }

    fun stringToDays(days: String): List<DayOfWeek> {
        return days.split("|").map { DayOfWeek.values()[it.toInt()] }
    }

    fun daysToString(days: List<DayOfWeek>): String {
        return days.map { it.ordinal }.joinToString(separator = "|")
    }

}