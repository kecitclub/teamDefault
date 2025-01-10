package com.example.teamdefault.ui.screen.calender_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamdefault.R
import dev.shivathapaa.nepalidatepickerkmp.NepaliDatePicker
import dev.shivathapaa.nepalidatepickerkmp.rememberNepaliDatePickerState

@Composable
fun NepaliCalenderScreen(modifier: Modifier = Modifier) {

    val defaultNepaliDatePickerState = rememberNepaliDatePickerState()

    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8),
        color = colorResource(id = R.color.primary_blue)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            NepaliDatePicker(state = defaultNepaliDatePickerState)

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NepaliCalenderScreenPreview() {
    NepaliCalenderScreen()

}