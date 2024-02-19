package com.ivanshalimov.composecoursesais

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MDHomeScreen() {
    Column {
        Button(
            onClick = {  }
        ) {
            val textStyle = LocalTextStyle.current
            Text(text = "Some text ${textStyle.fontSize}, ${textStyle.letterSpacing}")
        }
        TextField(value = "Some text", onValueChange = {})
    }
}

@Composable
fun MDHomeScreen1() {
    Column {
        Text(
            text = "Some text",
            modifier = Modifier.background(MaterialTheme.colorScheme.error)
        )
        Surface(color = MaterialTheme.colorScheme.error) {
            Text(text = "Some text")
        }
    }
}