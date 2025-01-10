package com.example.teamdefault.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamdefault.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import com.example.teamdefault.data.itemCategory
import com.example.teamdefault.ui.screen.category_screen.CategoryCardItem

@Composable
fun SampleScreen() {

    Box(){

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth(),
                //.padding(40.dp),
            //contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            
            item {

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Black,
                        contentColor = Color(0x338E8FF3)
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                        //.size(224.dp),
                    shape = RoundedCornerShape(bottomStartPercent = 8, bottomEndPercent = 8),

                    //border = BorderStroke(width = 1.dp, color = Color(0xFF617AD3))
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.language),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
                }
            }

            item {

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Black,
                        contentColor = Color(0x338E8FF3)
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                        //.size(224.dp),
                    shape = RoundedCornerShape(bottomStartPercent = 8, bottomEndPercent = 8),

                    border = BorderStroke(width = 1.dp, color = Color(0xFF617AD3))
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.story),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )

                }
            }

        }
        
    }

}




@Composable
fun PopularCard(
    navigateToStudy: (String) -> Unit
) {
    // Take only the first two items from itemCategory
    val twoCategories = itemCategory.take(2)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8),
        color = Color(0xFFEAF3FF)
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(8.dp)
                .padding(top = 10.dp)
                .fillMaxWidth(),
            columns = GridCells.Fixed(2)
        ) {
            items(twoCategories) { category ->
                CategoryCardItem(
                    items = category,
                    navigateToStudy = { navigateToStudy(category.title) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SampleScreenPreview() {

    SampleScreen()

}