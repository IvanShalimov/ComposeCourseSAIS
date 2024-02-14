package com.ivanshalimov.composecoursesais

import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val _counter = mutableIntStateOf(0)
    val counter: State<Int> = _counter

    fun onCounterClick() {
        _counter.value++
    }
}