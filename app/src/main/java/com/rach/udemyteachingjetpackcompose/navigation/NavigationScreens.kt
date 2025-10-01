package com.rach.udemyteachingjetpackcompose.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreens(
    onFirstClick:() -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Screen 1")
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                onFirstClick()
            }
        ) {
            Text("Go To 2 Screen")
        }
    }
}

@Composable
fun SecondScreens(
    onClick:() -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Screen 2")
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                onClick()
            }
        ) {
            Text("Go To 3 Screen")
        }
    }
}


@Composable
fun ThirdScreens(
    onClick: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Screen 3")
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                onClick()
            }
        ) {
            Text("Go To 1 Screen")
        }
    }
}