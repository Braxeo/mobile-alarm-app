package com.brandonkitt.alarms.enums

enum class DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;


}

fun List<DayOfWeek>.toShortString(): String = joinToString(separator = " ") { it.toShortString() }
fun DayOfWeek.toShortString(): String = toString().first().uppercase()