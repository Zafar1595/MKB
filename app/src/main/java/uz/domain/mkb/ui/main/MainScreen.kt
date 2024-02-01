package uz.domain.mkb.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.text.Html
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import uz.domain.mkb.R
import uz.domain.mkb.models.Mkb
import uz.domain.mkb.ui.main.detail.DetailBottomSheet

@Composable
fun MainScreen() {

    val fabVisible = remember { mutableStateOf(false) }
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBar()
        },
        content = { padding ->
            Content(padding, lazyListState) {
                fabVisible.value = it
            }
        },
        floatingActionButton = {
            if (fabVisible.value) {
                ExtendedFloatingActionButton(onClick = {
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(index = 0)
                    }
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_upward_24),
                        contentDescription = "Up"
                    )
                }
            }
        }
    )
}

@Composable
fun Content(
    padding: PaddingValues,
    lazyListState: LazyListState,
    viewModel: MainViewModel = koinViewModel<MainViewModel>(),
    scrollToTop: (visible: Boolean) -> Unit
) {
    setDefaultTextSize(viewModel, LocalContext.current)

    val viewState = viewModel.mkbList.observeAsState()

    LaunchedEffect(key1 = viewState, block = {
        viewModel.getAllMkb()
    })
    val fontSize = viewModel.textSize.observeAsState()

    LazyColumn(modifier = Modifier.padding(padding), state = lazyListState) {
        viewState.value?.forEach {
            item {
                ItemMkb(it, fontSize.value!!)
            }
        }
    }
    val showScrollToTopButton =
        remember { derivedStateOf { lazyListState.firstVisibleItemIndex > 0 } }
    scrollToTop.invoke(showScrollToTopButton.value)

}

@Composable
fun ItemMkb(it: Mkb, fontSize: Int) {
    val clickItemState = remember { mutableStateOf(false) }

    if (clickItemState.value) {
        DetailBottomSheet(it, fontSize) {
            clickItemState.value = false
        }
    }
    Column(
        modifier = Modifier
            .clickable { clickItemState.value = true }
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
    ) {

        Row {
            Text(
                stringResource(R.string.cod),
                modifier = Modifier.padding(start = 8.dp, end = 0.dp, top = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                it.diagnosis_Num,
                modifier = Modifier.padding(start = 2.dp, end = 8.dp, top = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = fontSize.sp
            )
        }

        Spacer(modifier = Modifier.size(4.dp))

        Row {
            Text(
                stringResource(R.string.name_ru),
                modifier = Modifier.padding(start = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                it.diagnosis_Name,
                modifier = Modifier.padding(start = 2.dp, end = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = fontSize.sp
            )
        }

        Spacer(modifier = Modifier.size(4.dp))
        Row {
            Text(
                stringResource(R.string.name_uz),
                modifier = Modifier.padding(start = 8.dp, end = 0.dp, bottom = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                it.diagnosis_Name_Uz,
                modifier = Modifier.padding(start = 2.dp, end = 8.dp, bottom = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = fontSize.sp
            )
        }

    }
}

@Composable
fun TopBar(viewModel: MainViewModel = koinViewModel<MainViewModel>()) {

    val text = remember { mutableStateOf("") }

    if (text.value.isNotEmpty() && text.value.length > 2) {
        viewModel.searchMkb(text.value)
    } else if (text.value.isEmpty()) {
        viewModel.getAllMkb()
    }

    val settingsClickState = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        OutlinedTextField(
            value = text.value,
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search"
                )
            },
            label = {
                Text(text = stringResource(R.string.search))
            },
            onValueChange = {
                text.value = it
            },
            modifier = Modifier
                .weight(9f)
                .padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
            singleLine = true,
            shape = RoundedCornerShape(7.5.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                cursorColor = Color.Black,
                focusedSupportingTextColor = Color.Black
            ),
        )
        Image(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = "settings",
            modifier = Modifier
                .size(30.dp)
                .weight(1.5f)
                .padding(end = 16.dp)
                .align(androidx.compose.ui.Alignment.CenterVertically)
                .clickable {
                    settingsClickState.value = true
                }
        )
    }

    val context = LocalContext.current
    if (settingsClickState.value) {
        FontSizeBottomSheet(viewModel.textSize.value!!) { newSize ->
            settingsClickState.value = false
            viewModel.textSize.value = newSize
            saveNewTextSize(context, newSize)
        }
    }

}

fun saveNewTextSize(context: Context, size: Int) {
    val preferences: SharedPreferences =
        context.getSharedPreferences("mkb", Context.MODE_PRIVATE)
    val editor = preferences.edit()
    editor.putInt("textSize", size)
    editor.apply()
}

fun setDefaultTextSize(viewModel: MainViewModel, context: Context) {
    val preferences: SharedPreferences =
        context.getSharedPreferences("mkb", Context.MODE_PRIVATE)

    if (preferences.getInt("textSize", 0) != 0)
        viewModel.textSize.value = preferences.getInt("textSize", 0)
    else
        viewModel.textSize.value = 14
}