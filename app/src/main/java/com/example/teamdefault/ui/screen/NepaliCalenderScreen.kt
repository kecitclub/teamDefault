package com.example.teamdefault.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.shivathapaa.nepalidatepickerkmp.NepaliDatePicker
import dev.shivathapaa.nepalidatepickerkmp.rememberNepaliDatePickerState

@Composable
fun NepaliCalenderScreen() {

    val defaultNepaliDatePickerState = rememberNepaliDatePickerState()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        NepaliDatePicker(state = defaultNepaliDatePickerState)

    }


}

@Preview(showBackground = true)
@Composable
private fun NepaliCalenderScreenPreview() {
    NepaliCalenderScreen()

}