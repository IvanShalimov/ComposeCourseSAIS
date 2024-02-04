package com.ivanshalimov.composecoursesais

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
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

@Composable
fun HomeScreen1() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(text = stringResource(id = R.string.title), fontSize = 32.sp)
        Text(text = stringResource(id = R.string.description), fontSize = 20.sp, modifier = Modifier.align(Start))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen1Preview() {
    HomeScreen1()
}

@Composable
fun HomeScreen2() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.title), fontSize = 32.sp)
        Spacer(modifier = Modifier
            //.width(8.dp))
            .weight(1f)
        )
        Text(text = stringResource(id = R.string.description), fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen2Preview() {
    HomeScreen2()
}

@Composable
fun HomeScreen3() {
    Box {
        Text("N", fontSize = 48.sp)
        Text(text = "ame", modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen3Preview() {
    HomeScreen3()
}

@Composable
fun HomeScreen4() {
    Column(
        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.start_padding), top = dimensionResource(id = R.dimen.top_padding))
    ) {
        Text(stringResource(id = R.string.title), fontSize = 48.sp)
        Text(text = stringResource(id = R.string.description), fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen4Preview() {
    HomeScreen4()
}

@Composable
fun HomeScreenList(list: List<String>) {
    if(list.isEmpty()) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text("Empty list")
        }
    } else {
        Column {
            for (text in list) {
                Text(text = text)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenListPreview() {
    HomeScreenList(emptyList())
}