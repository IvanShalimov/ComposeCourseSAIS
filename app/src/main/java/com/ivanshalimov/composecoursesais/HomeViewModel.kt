package com.ivanshalimov.composecoursesais

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel: ViewModel() {

    private val _counter = MutableStateFlow(0)//mutableIntStateOf(0)
    val counter: StateFlow<Int> = _counter

    fun onCounterClick() {
        _counter.value++
    }
}