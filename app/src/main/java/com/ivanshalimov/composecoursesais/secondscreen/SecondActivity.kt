package com.ivanshalimov.composecoursesais.secondscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //navigation compose
            Column(modifier = Modifier.fillMaxSize()) {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "userList",
                    modifier = Modifier.weight(1f)
                ) {
                    composable("userList") {
                        UserList(
                            onUserClick = { navController.navigate("user") },
                        )
                    }
                    composable("user") { backStackEntry ->
                        val userListEntry = remember(backStackEntry) {
                            navController.getBackStackEntry("userList")
                        }
                        UserScreen(
                            usersSharedViewModel = viewModel(userListEntry)
                        )
                    }
                }

                Text(
                    text = "User List",
                    modifier = Modifier.clickable { navController.navigate("userList") }
                )
            }
        }

    }
}