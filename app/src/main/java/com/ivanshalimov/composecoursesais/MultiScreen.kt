package com.ivanshalimov.composecoursesais

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FirstScreen(
    onNavigateToSecond: () -> Unit,
    onNavigateToThird: () -> Unit,
) {
    Column {
        Text(text = "First screen")

        Text(
            text = "Second",
            modifier = Modifier.clickable(onClick = onNavigateToSecond)
        )

        Text(
            text = "Third",
            modifier = Modifier.clickable(onClick = onNavigateToThird)
        )
    }
}

@Composable
fun SecondScreen() {
    Text(text = "Second Screen")
}

@Composable
fun ThirdScreen() {
    Text(text = "Third screen")
}