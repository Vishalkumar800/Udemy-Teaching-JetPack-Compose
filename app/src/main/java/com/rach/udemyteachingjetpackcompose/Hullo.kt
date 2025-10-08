package com.rach.udemyteachingjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreenUllo(mainViewModel: MainViewModel = viewModel()) {

    val email by mainViewModel.email.collectAsState()
    val password by mainViewModel.password.collectAsState()



    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = email,
            onValueChange = {
                mainViewModel.onEmailChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Enter email") }
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                mainViewModel.onPasswordChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Enter password") }
        )

    }

}