package com.rach.udemyteachingjetpackcompose.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreens(
    onClick: (String) -> Unit
) {
    var name by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Screen 1")
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            label = {Text("Enter your marji")}
        )

        Button(
            onClick = {
                onClick(name)
            }
        ) {
            Text("Go To 2 Screen")
        }
    }
}

@Composable
fun SecondScreens(
    name: String,
    onClick: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Screen 2")
        Spacer(modifier = Modifier.height(20.dp))
        Text(name)
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