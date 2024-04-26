package GDSH.CUATRO.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.DialogProperties

@Composable
fun DeleteButton(entryState : MutableState<List<String>>){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,    ) {
        val hidden: MutableState<Boolean> = remember { mutableStateOf(false) }

        Button(onClick = { hidden.value = !hidden.value }) {
            Text("Delete People")
        }

        if (hidden.value) {
            AlertDialog(
                onDismissRequest = {
                    hidden.value = false
                },
                properties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                ),
                confirmButton = {
                    Button(
                        onClick = {
                            entryState.value = emptyList()
                            hidden.value = false
                        }
                    ) {
                        Text("OK")
                    }
                },
                title = {
                    Text("Do you want to delete all the names?", color = Color.White)
                },
                text = {
                    Text("This action cannot be undone", color = Color.White)
                },
                containerColor = Color.Black,
                dismissButton = {
                    Button(
                        onClick = {
                            hidden.value = false
                        }
                    ) {
                        Text("Cancel")
                    }
                },

                )
        }
    }
}