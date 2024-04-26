package com.alexisflop.labo03.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.alexisflop.labo03.model.Subject
import com.alexisflop.labo03.viewModel.DataViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ObjectListComponent(modifier: Modifier = Modifier) {
    val viewModel = DataViewModel()
    val dataState: MutableState<List<Subject>?> = remember { mutableStateOf(null) }
    val Loading:MutableState<Boolean> = remember { mutableStateOf(false) }
    val lifeCycleScope = LocalLifecycleOwner.current.lifecycleScope


    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
        Button(onClick = {
            Loading.value = true
            lifeCycleScope.launch() {
                delay(3000)
                val data = viewModel.getData()
                dataState.value = data
                Loading.value = false
            }
        }) {

            Text(text = "Get SUBJECTS from database")
        }

            if (Loading.value) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(50.dp)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .weight(9f)
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                ) {
                    itemsIndexed(dataState.value ?: emptyList()) { index, item ->
                        ObjectComponent(propertyOne = item.getName(), propertyTwo = item.getSeccion())
                }
            }
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun ObjectListComponentPreview() {
    ObjectListComponent()
}