package com.ivanshalimov.composecoursesais

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // val counter = mutableIntStateOf(0)
        //val checked = mutableStateOf(false)
        //val text = mutableStateOf("some text")
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                var route by remember { mutableStateOf("first") }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                ) {
                    when (route) {
                        "first" -> FirstScreen(
                            onNavigateToSecond = { route = "second" },
                            onNavigateToThird = { route = "third" }
                        )
                        "second" -> SecondScreen()
                        "third" -> ThirdScreen()
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "First", modifier = Modifier.clickable { route = "first" })
                    Text(text = "Second", modifier = Modifier.clickable { route = "second" })
                    Text(text = "Third", modifier = Modifier.clickable { route = "third" })
                }
            }
        }
    }
}