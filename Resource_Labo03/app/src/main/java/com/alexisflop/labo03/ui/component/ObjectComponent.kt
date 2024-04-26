package com.alexisflop.labo03.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ObjectComponent(propertyOne: String, propertyTwo: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "School Icon",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = propertyOne, color = Color.White)
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = propertyTwo, color = Color.White)
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun ObjectComponentPreview() {
    ObjectComponent(propertyOne = "Math", propertyTwo = "History")
}
