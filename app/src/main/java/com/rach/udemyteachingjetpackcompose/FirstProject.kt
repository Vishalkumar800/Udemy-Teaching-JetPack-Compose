package com.rach.udemyteachingjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rach.udemyteachingjetpackcompose.ui.theme.UdemyTeachingJetPackComposeTheme

@Composable
fun FirstProject() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.image2),
                contentDescription = "image 2",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f))
                        )
                    )

            )

            Column(
                modifier = Modifier
                    .align(
                        Alignment.BottomStart
                    )
                    .padding(16.dp)
            ) {
                Text(
                    "Soniya", color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )

                Text(
                    "Native Android Developer",
                    color = Color.White
                )
            }
        }
    }

}

@Composable
fun BrushStudy(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color.Red, Color.Green, Color.Yellow)
                )
            )
    ){}
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    UdemyTeachingJetPackComposeTheme {
        BrushStudy()
    }
}