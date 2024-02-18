package com.ivanshalimov.composecoursesais.thirdscreen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ivanshalimov.composecoursesais.thirdscreen.ui.theme.ComposeCourseSAISTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCourseSAISTheme {
                Column {
                    var checkbox by remember { mutableStateOf(false) }
                    Checkbox(checked = checkbox, onCheckedChange = { checkbox = it })
                    if (checkbox) {
                        val scope = rememberCoroutineScope()
                        Text(text = "Click", modifier = Modifier.clickable {
                            scope.launch { counter() }
                        })
                        LaunchedEffect(key1 = Unit) {
                            counter()
                        }
                    }
                }
            }
        }
    }

    suspend fun counter() {
        var count = 0
        while (true) {
            Log.d("Ivan", "count: ${count++}")
            delay(1000L)
        }
    }
}