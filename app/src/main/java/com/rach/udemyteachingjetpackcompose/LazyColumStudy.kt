package com.rach.udemyteachingjetpackcompose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val fruits = listOf(
    "Apple","Mango","1","Toffee","Orange",
    "Apple","Mango","1","Toffee","Orange",
    "Apple","Mango","1","Toffee","Orange"
)

@Composable
fun LazyColumnStudy() {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {
        items(fruits){item ->
            Text(item, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

