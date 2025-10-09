package com.rach.udemyteachingjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rach.udemyteachingjetpackcompose.bottomBar.MyApp
import com.rach.udemyteachingjetpackcompose.ui.theme.UdemyTeachingJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UdemyTeachingJetPackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    //FirstProject()
                    //  TomuScreen()
                    MyApp()

                }
            }
        }
    }
}


@Composable
fun ClickableComparisonScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // 🟢 Normal Ripple Clickable
        Text(
            text = "Normal Click (Ripple dikhega)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(Color(0xFFFFE0B2), RoundedCornerShape(12.dp))
                .clickable {
                    Log.d("ClickableDemo", "Normal Clicked!")
                }
                .padding(20.dp),
            color = Color.Black)

        Spacer(modifier = Modifier.height(40.dp))

        // 🔵 Custom Clickable (No Ripple)
        Text(
            text = "Custom Click (Ripple nahi hoga)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(Color(0xFFC8E6C9), RoundedCornerShape(12.dp))
                .clickable(
                    indication = null, // Ripple disable
                    interactionSource = remember { MutableInteractionSource() }) {
                    Log.d("ClickableDemo", "Custom Clicked!")
                }
                .padding(20.dp),
            color = Color.Black)
    }
}
