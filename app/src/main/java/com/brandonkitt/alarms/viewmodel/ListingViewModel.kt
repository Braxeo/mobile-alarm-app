package com.brandonkitt.alarms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.brandonkitt.alarms.entities.AlarmEntity
import com.brandonkitt.alarms.repository.ListingRepository

class ListingViewModel constructor(
    repository: ListingRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    val alarms: LiveData<List<AlarmEntity>> = repository.getAlarms()





}