package com.ivanshalimov.composecoursesais.fifthactivity

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreenFifth() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            //.width(400.px)
    ) {
        Text(text = "Some text", fontSize = 20.sp, modifier = Modifier.myLayout())
    }
}

fun Modifier.myLayout() = layout { measurable, constraints ->
    Log.d("Ivan", "constraints = $constraints")
    val placeable = measurable.measure(constraints) // Measure children
    Log.d("Ivan", "placeable, width = ${placeable.width}, height = ${placeable.height}")
    layout(placeable.width, placeable.height) { // Decide own size
        placeable.placeRelative(10, 10) // Place children
    }
}

inline val Int.px: Dp
    @Composable get() = with(LocalDensity.current) { this@px.toDp() }