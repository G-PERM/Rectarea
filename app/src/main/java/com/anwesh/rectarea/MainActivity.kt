package com.anwesh.rectarea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var length by remember { mutableStateOf("") }
            var width by remember { mutableStateOf("") }
            var area by remember { mutableStateOf<Double?>(null) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedTextField(
                    value = length,
                    onValueChange = { length = it },
                    label = { Text("Length") }
                )

                OutlinedTextField(
                    value = width,
                    onValueChange = { width = it },
                    label = { Text("Width") }
                )

                Button(onClick = {
                    val l = length.toDoubleOrNull()
                    val w = width.toDoubleOrNull()
                    area = if (l != null && w != null) l * w else null
                }) {
                    Text("Calculate Area")
                }

                area?.let {
                    Text(text = "Area: $it")
                } ?: Text("Enter valid numbers")
            }
        }
    }
}
