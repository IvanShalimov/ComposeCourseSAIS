package com.ivanshalimov.composecoursesais

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(userName: String) {
    Text(
        text = "HomeScreen for $userName",
        fontSize = 32.sp,
        color = Color.White,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Black)
            //.width(120.dp),
            .fillMaxWidth()
    )
    //Text(text = "123456789")
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen("Ivan")
}