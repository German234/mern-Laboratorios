package com.alexisflop.labo03.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alexisflop.labo03.model.Subject
import com.alexisflop.labo03.viewModel.DataViewModel

@Composable
fun InsertDataComponent(modifier: Modifier = Modifier, viewModel: DataViewModel = viewModel()) {
    val textFieldPropertyOne: MutableState<String> = remember { mutableStateOf("") }
    val textFieldPropertyTwo: MutableState<String> = remember { mutableStateOf("") }
    val viewModel = DataViewModel()

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(modifier = Modifier.padding(bottom = 5.dp),  text = "Insert your data here")

        TextField(modifier = Modifier.padding(bottom = 5.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            value = textFieldPropertyOne.value,
            onValueChange = { textFieldPropertyOne.value = it },
            placeholder = {
                Text(text = "Insert the Subject here")
            })

        TextField(modifier = Modifier.padding(bottom = 5.dp), singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            value = textFieldPropertyTwo.value,
            onValueChange = { textFieldPropertyTwo.value = it },
            placeholder = {
                Text(text = "Insert the section here")

            })

        Button(modifier = Modifier.padding(bottom = 5.dp), onClick = {
            val myList : MutableList<Subject> = mutableListOf()
            viewModel.setData(Subject(textFieldPropertyOne.value , textFieldPropertyTwo.value))

            textFieldPropertyOne.value = ""
            textFieldPropertyTwo.value = ""
        }) {

            Text(text = "Set data")
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun InsertDataComponentPreview() {
    InsertDataComponent(modifier = Modifier)
}