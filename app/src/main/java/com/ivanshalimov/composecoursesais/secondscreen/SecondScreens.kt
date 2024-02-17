package com.ivanshalimov.composecoursesais.secondscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserList(
    onUserClick: () -> Unit,
    usersSharedViewModel: UsersSharedViewModel = viewModel()
) {
    Column {
        Text(text = "User List")
        Text(
            text = "User 1",
            modifier = Modifier.clickable { onUserClick() }
        )
    }
}

@Composable
fun UserScreen(
    usersSharedViewModel:UserViewModel = hiltViewModel()
) {
    Text(text = "User")
}