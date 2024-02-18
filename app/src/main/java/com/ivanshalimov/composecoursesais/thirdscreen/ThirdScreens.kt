package com.ivanshalimov.composecoursesais.thirdscreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.math.roundToInt

@Composable
fun HomeScreenThird() {
    Column {
        var checked by remember { mutableStateOf(false) }
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        if (checked) {
            Log.d("Ivan", "HomeScreen log")
            SideEffect {
                Log.d("Ivan", "HomeScreen log in SideEffect")
            }
            val a = 1/ 0
        }
    }
}

@Composable
fun HomeScreenSlide() {
    Column {
        val sliderPosition = remember { mutableFloatStateOf(1f) }
        MySlider(sliderPosition)
        val roundedPosition by remember {
            derivedStateOf {
                sliderPosition.floatValue.roundToInt()
            }
        }
        Text(text = "$roundedPosition")
        Log.d("Ivan", "HomeScreen $roundedPosition")
    }
}

@Composable
fun MySlider(sliderPosition: MutableState<Float>) {
    Slider(
        value = sliderPosition.value,
        valueRange = 1f..10f,
        onValueChange = { sliderPosition.value = it }
    )
}