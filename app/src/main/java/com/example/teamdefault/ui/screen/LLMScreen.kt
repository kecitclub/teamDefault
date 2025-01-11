package com.example.teamdefault.ui.screen

import com.example.teamdefault.MainViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LLMScreen(viewModel: MainViewModel) {
    var userInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Enter your question") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            viewModel.fetchResponse(userInput) { response ->
                result = response ?: "Error occurred"
            }
        }) {
            Text("Ask")
        }
        Text("Response:", style = MaterialTheme.typography.bodyMedium)
        Text(result)
    }
}
