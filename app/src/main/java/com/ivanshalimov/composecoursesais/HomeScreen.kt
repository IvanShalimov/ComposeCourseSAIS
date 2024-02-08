package com.ivanshalimov.composecoursesais


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.State
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

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

@Composable
fun HomeScreen5() {
    Box(contentAlignment = Center, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .width(160.dp)
            .height(120.dp)
            // RoundedCornerShape(size = 16.dp); CutCornerShape(size= 16.dp)
            .background(
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Yellow, Color.Green)),
                alpha = 0.2f,
                shape = CircleShape
            )
            .border(
                width = 2.dp,
                color = Color.DarkGray,
                shape = CircleShape
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen5Preview(){
    HomeScreen5()
}

@Composable
fun HomeScreen6() {
    Box(contentAlignment = Center, modifier = Modifier.fillMaxSize()) {
        /*Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null
        )*/
        AsyncImage(
            model = "https://developer.android.com/images/android-go/next-billion-users_856.png",
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen6Preview() {
    HomeScreen6()
}


@Composable
fun HomeScreenInput(counter: State<Int>, onCounterClick:()-> Unit) {
    val counterValue = counter.value
    Text(
        text = "Clicks: $counterValue",
        modifier = Modifier.clickable { onCounterClick() }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenInputPreview() {
    //HomeScreenInput(0) {}
}