package com.example.teamdefault.ui.component

import com.example.teamdefault.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputForm(
    title: String,
    icon: Int,
    onChange: (String) -> Unit,
    value: String = "",
    disable: Boolean = false,
    colorPaint: Int = R.color.white,
    modifier: Modifier = Modifier
) {

    val textInput = ""

    Spacer(modifier = Modifier.height(12.dp))
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = value.ifBlank { textInput },
        onValueChange = {},
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                tint = colorResource(
                    id = R.color.primary_purple
                )
            )
        },
        label = { Text(text = "Enter Your $title") },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = colorResource(id = colorPaint),
            focusedContainerColor = colorResource(id = colorPaint)
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    )

}

@Preview
@Composable
private fun InputFormPreview() {
    InputForm(title = "", icon = 0, onChange = {})
}