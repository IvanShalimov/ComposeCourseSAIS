package com.ivanshalimov.composecoursesais.secondscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val someRepository: SomeRepository,
    private val savedState: SavedStateHandle
): ViewModel() {

    init {
        val userId = savedState.get<String>("id")
    }
}