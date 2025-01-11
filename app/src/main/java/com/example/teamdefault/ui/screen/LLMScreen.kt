package com.example.teamdefault.ui.screen

import com.example.teamdefault.MainViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LLMScreen(viewModel: MainViewModel, modifier: Modifier) {
    var userInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text(text="Enter your question", fontSize = 20.sp) },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
            viewModel.fetchResponse(userInput) { response ->
                result = response ?: "Error occurred"
            }
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier.height(40.dp)
        ) {
            Text("Ask", color = Color.Black, fontSize = 20.sp)
        }
        Text("Answer:", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyLarge, fontSize = 20.sp)
        Text(result, color = Color.White, fontSize = 18.sp)
    }
}
