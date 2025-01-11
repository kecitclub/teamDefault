package com.example.teamdefault.ui.screen.category_screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamdefault.R
import com.example.teamdefault.ui.component.AppIconButton
import java.util.Timer

@Composable
fun FolkTalesScreen(modifier: Modifier = Modifier) {

    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8),
        color = Color(0xFFEAF3FF)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "मुसा",
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.hunter_tale),
                contentDescription = null
            )

            Text(
                text = "एक समयको कुरा हो, एक सानो गाउँमा एउटा हात्ती बस्थ्यो। " +
                        "यस हात्तीको नाम था– मुसा। मुसाले सधैँ गाउँका मानिसहरूलाई मद्दत गर्ने गर्छ।" +
                        " एक दिन गाउँमा ठूलो आगो लाग्यो र सबै डरले भाग्न थाले। मुसा, जो चुपचाप रहन्थ्यो, " +
                        "आफ्नो विशाल आकारको उपयोग गर्दै सबैलाई अगाडि पठाउने र आगो निभाउन प्रयास गर्दै अघि बढ्यो। अन्ततः, " +
                        "मुसाले एक नदीको किनारमा पुगेर पानी ल्याएर आगो निभायो। गाउँवासीहरूले उसको साहस र " +
                        "दयालुता देखेर मुसालाई ‘दयालु हात्ती’ भनेर सम्झना गर्न थाले। आज पनि गाउँमा दयालुता र साहसको प्रतिमूर्ति मानिन्छ मुसा।",
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                textAlign = TextAlign.Justify,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            TimerFooter()


        }

    }

}

@Composable
private fun TimerFooter(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(bottom = 80.dp)) {
        ActionsIcons(icon = R.drawable.play, title = "")
        Spacer(Modifier.width(100.dp))
        ActionsIcons(icon = R.drawable.stop, title = "")
    }
}

@Composable
private fun ActionsIcons(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    title: String
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AppIconButton(
            icon = icon,
            modifier = Modifier
                .drawBehind {
                    drawCircle(
                        color = Color(0xFF6A5AE0),
                    )
                }
                .padding(8.dp)
        ) {}

        Spacer(Modifier.height(40.dp))

        Text(
            text = title, style = TextStyle(
                fontSize = 14.sp,
                // fontFamily = montserratFont,
                //color = TimerGrayColor
            )
        )
    }
}


@Preview
@Composable
private fun StoryScreenPreview() {

    FolkTalesScreen()
}