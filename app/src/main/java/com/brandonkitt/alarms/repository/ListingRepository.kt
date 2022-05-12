package com.brandonkitt.alarms.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.brandonkitt.alarms.DummyEndpoint
import com.brandonkitt.alarms.entities.AlarmEntity
import com.brandonkitt.alarms.mappers.AlarmMapper
import com.brandonkitt.alarms.room.dao.AlarmDao
import com.brandonkitt.alarms.room.dbo.AlarmDbo
import javax.inject.Inject

class ListingRepository @Inject constructor(
    private val alarmDao: AlarmDao,
    private val dummyEndpoint: DummyEndpoint
) {
    fun getAlarms(): LiveData<List<AlarmEntity>> = MutableLiveData(dummyEndpoint.getAlarms())  // Transformations.map(alarmDao.getAlarms()){ AlarmMapper.toEntity(it) }
}