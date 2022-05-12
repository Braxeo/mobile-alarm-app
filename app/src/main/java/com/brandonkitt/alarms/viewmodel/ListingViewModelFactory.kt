package com.brandonkitt.alarms.viewmodel

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.brandonkitt.alarms.repository.ListingRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ListingViewModelFactory @AssistedInject constructor(
    private val repository: ListingRepository,
    @Assisted owner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(owner, null) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T = ListingViewModel(repository, handle) as T
}

@AssistedFactory
interface ListingViewModelAssistedFactory {
    fun create(owner: SavedStateRegistryOwner): ListingViewModelFactory
}