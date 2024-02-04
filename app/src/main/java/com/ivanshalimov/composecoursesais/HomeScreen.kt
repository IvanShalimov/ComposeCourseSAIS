package com.ivanshalimov.composecoursesais

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(userName: String) {
    Text(
        text = "HomeScreen for $userName",
        fontSize = 32.sp,
        color = Color.Green
    )
    //Text(text = "123456789")
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen("Ivan")
}