package GDSH.CUATRO.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InsertNameComp(entriesState : MutableState<List<String>>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        val nameState = remember { mutableStateOf("") }


        TextField(
            value = nameState.value,
            onValueChange = { nameState.value = it },
            label = { Text("Enter a name") }
        )

        Button(
            onClick = {
                if (nameState.value.isNotBlank()) {
                    entriesState.value = entriesState.value + nameState.value
                    nameState.value = ""
                }
            }
        ) {
            Text(text = "Add")
        }

        LazyColumn(modifier = Modifier.height(200.dp).fillMaxWidth().padding(top = 10.dp)) {
            items(entriesState.value) { entry ->
                val index = entriesState.value.indexOf(entry)
                val color = if (index % 2 == 0) Color.LightGray else Color.Gray
                ListElement(text = entry, color = color)
            }
        }
    }
}
