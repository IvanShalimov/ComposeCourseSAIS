package com.ivanshalimov.composecoursesais.firstscreen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.ivanshalimov.composecoursesais.EvenOdd
import com.ivanshalimov.composecoursesais.R

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
        verticalAlignment = CenterVertically
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
        Box(contentAlignment = Center, modifier = Modifier.fillMaxSize()) {
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
fun HomeScreenInput(
    counter: State<Int>,
    onCounterClick:()-> Unit,
    checked: State<Boolean>,
    onCheckedChange: (Boolean) -> Unit
    ) {
    Log.d("Ivan", "HomeScreen")
    val counterValue = counter.value
    Column {
        ClickCounter(
            uppercase = checked.value,
            counterValue = counterValue,
            onCounterClick = onCounterClick)
        InfoText(
            text = if(counterValue < 3) "More" else "Enough"
        )
        UpperCaseCheckBox(
            checked= checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
fun UpperCaseCheckBox(
    checked: State<Boolean>,
    onCheckedChange: (Boolean) -> Unit
) {
    val checkedValue = checked.value
    Row(verticalAlignment = CenterVertically) {
        Checkbox(checked = checkedValue, onCheckedChange = onCheckedChange)
        Text(text = "UPPERCASE")
    }
}

@Composable
fun ClickCounter(
    uppercase: Boolean,
    counterValue: Int,
    onCounterClick:()-> Unit
) {
    Log.d("Ivan", "ClickCounter: $counterValue")
    val evenOdd = remember(uppercase) { EvenOdd(uppercase) }
    Text(
        text = "Clicks: $counterValue ${evenOdd.check(counterValue)}",
        modifier = Modifier.clickable {
            Log.d("Ivan", "--- click ---")
            onCounterClick()
        }
    )
}

@Composable
fun InfoText(text: String) {
    Log.d("Ivan", "InfoText: $text")
    Text(text = text, fontSize = 24.sp)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenInputPreview() {
    //HomeScreenInput(0) {}
}

@Composable
fun HomeScreenCheckBox(
    checked: State<Boolean>,
    onCheckedChange: (Boolean) -> Unit
) {
    val checkedValue = checked.value

    Row(verticalAlignment = CenterVertically) {
        Checkbox(checked = checkedValue, onCheckedChange = onCheckedChange)
        Text(
            text = "some checkbox text",
            fontSize = 18.sp,
            modifier = Modifier.clickable { onCheckedChange(!checkedValue) })
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenCheckBoxPreview() {
    val value = remember {
        mutableStateOf(false)
    }
    HomeScreenCheckBox(
        value
    ) {}
}

@Composable
fun HomeScreenTextField(
    text: State<String>,
    onValueChang: (String) -> Unit
) {
    val textValue = text.value
    OutlinedTextField(value = textValue, onValueChange = onValueChang)
}

@Composable
@Preview(showBackground = true)
fun HomeScreenTextFieldPreview() {
    val value = remember {
        mutableStateOf("Text")
    }
    HomeScreenTextField(
        value
    ) {}
}


@Composable
fun HomeScreenCheckBox2() {
    var checked by remember {mutableStateOf(false)}
    Column {
        Row(verticalAlignment = CenterVertically) {
            Checkbox(checked = checked, onCheckedChange = { value -> checked = value })
            Text("More details", fontSize = 18.sp)
        }
        if (checked) {
            Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        }
    }
}

@Composable
fun HomeScreenList() {
    Log.d("Ivan","HomeScreen")
    val list = remember {
        List(20) { "Item ${it+1}"}.toMutableStateList()
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.border(width = 2.dp, color = Color.Green)
    ) {
        items(list) {item ->
            SomeItem(text = item)
        }
    }
}

@Composable
fun SomeItem(text: String) {
    Log.d("Ivan", "SomeItem: $text")
    Text(
        text = text,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
            .padding(16.dp)
    )
}

@Composable
fun HomeScreenClicker(
    homeViewModel: HomeViewModel = viewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()

    Column {
        ClickCounter(
            count = uiState.count,
            onCounterClick = homeViewModel::onCounterClick
        )
        EnableFeature(
            enabled = uiState.enabled,
            onEnabledChange = homeViewModel::setEnabled
        )
    }
}

@Composable
fun ClickCounter(
    count: Int,
    onCounterClick: () -> Unit
) {
    Text(
        text = "Clicks: $count",
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
}

@Composable
fun EnableFeature(
    enabled: Boolean,
    onEnabledChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = CenterVertically) {
        Checkbox(checked = enabled, onCheckedChange = onEnabledChange)
        Text("enable feature")
    }
}

@Preview(showBackground = true)
@Composable
fun ClickCounterPreview() {
    ClickCounter(
        count = 5,
        onCounterClick = {}
    )
}

@Composable
fun HomeScreenModifierOrder() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .border(width = 2.dp,color = Color.Black)
            .padding(32.dp)
            .border(width = 2.dp,color = Color.Red)
            .background(color = Color.Green)
    ) {
        Text(text = "Some text", fontSize = 30.sp)
    }
}