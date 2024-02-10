package com.ivanshalimov.composecoursesais

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counter = mutableStateOf(0)
        //val checked = mutableStateOf(false)
        //val text = mutableStateOf("some text")
        setContent {
            HomeScreenInput(counter = counter) {
                counter.value++
            }
        }
    }
}