package com.ivanshalimov.composecoursesais.secondscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //handmade navigation
            Column(modifier = Modifier.fillMaxSize()) {
                var route by remember { mutableStateOf("userList") }

                Box(modifier = Modifier.weight(1f)) {
                    when (route) {
                        "userList" -> { UserList(onUser1Click = { route = "user/1" }) {
                            route = "user/2"
                        }
                        }
                        "user/1" -> { UserScreen(id = "1") }
                        "user/2" -> { UserScreen(id = "2") }
                        else -> {
                            UserList(onUser1Click = { route = "user/1" }) {
                                route = "user/2"
                            }
                        }
                    }
                }

                Text(
                    text = "Users",
                    modifier = Modifier.clickable { route = "userList" }
                )
            }

        }
    }
}
