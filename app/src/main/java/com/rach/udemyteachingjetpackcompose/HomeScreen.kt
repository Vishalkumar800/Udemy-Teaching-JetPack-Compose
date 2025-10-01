package com.rach.udemyteachingjetpackcompose

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rach.udemyteachingjetpackcompose.ui.theme.UdemyTeachingJetPackComposeTheme

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){

        Button(
            onClick = {
                Toast.makeText(context,"Bhai Accha Hai", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )
        ) {
            Text("SEND", color = Color.White , fontWeight = FontWeight.Bold)
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    UdemyTeachingJetPackComposeTheme {
        HomeScreen()
    }
}
