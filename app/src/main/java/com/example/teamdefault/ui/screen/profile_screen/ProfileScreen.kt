import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamdefault.R
import com.example.teamdefault.data.avatarProfile
import com.example.teamdefault.data.backgroundProfile
import com.example.teamdefault.ui.component.InputForm

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        color = colorResource(id = R.color.white_background),
        shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8)
    ) {
        Column(
            Modifier
                .padding(20.dp)
                .padding(top = 80.dp)
        ) {
            InputForm(
                title = "Username",
                icon = R.drawable.user,
                onChange = {},
                value = "Hari",
                disable = true,
                colorPaint = R.color.tertiary_blue
            )
            InputForm(
                title = "Email",
                icon = R.drawable.email,
                onChange = {},
                value = "hari@gmail.com",
                disable = true,
                colorPaint = R.color.tertiary_blue
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = 85.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier.size(180.dp),
            color = colorResource(id = backgroundProfile[0]!!),
            shape = RoundedCornerShape(20)
        ) {
            Image(
                painter = painterResource(id = avatarProfile[0]!!),
                contentDescription = "profile",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            )
        }
        IconButton(
            modifier = Modifier
                .size(48.dp)
                .offset(x = 76.dp, y = 76.dp),
            onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = colorResource(id = R.color.primary_purple),
                contentColor = Color.White
            ),
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
        }
    }
}
@Preview
@Composable
fun ProfileScreenPreview(modifier: Modifier = Modifier) {
    ProfileScreen()
}