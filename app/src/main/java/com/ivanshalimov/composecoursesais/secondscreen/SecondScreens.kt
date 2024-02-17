package com.ivanshalimov.composecoursesais.secondscreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserList(
    onUser1Click: () -> Unit,
    onUser2Click: () -> Unit
) {
    Column {
        Text(text = "User List")
        Text(
            text = "User 1",
            modifier = Modifier.clickable { onUser1Click() }
        )
        Text(
            text = "User 2",
            modifier = Modifier.clickable { onUser2Click() }
        )
    }
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun UserScreen(
    id: String,
    viewModel: UserViewModel = viewModel()
) {
    Text(text = "User: $id")
    Log.d("Ivan","user $id")
    Log.d("Ivan","viewModel ${viewModel.hashCode().toHexString()}")
    Log.d("Ivan","viewModelStoreOwner ${LocalViewModelStoreOwner.current?.javaClass?.simpleName}")
}