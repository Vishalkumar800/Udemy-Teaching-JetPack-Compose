package com.rach.udemyteachingjetpackcompose.bottomBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screens(val route: String) {

    object HomeScreen: Screens("HomeScreen")
    object Screen2: Screens("Screen2")
    object Screen3: Screens("Screen3")
    object Screen4: Screens("Screen4")
}

@Composable
fun MyAppNav(modifier: Modifier = Modifier,navController: NavHostController) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ){
        composable(Screens.HomeScreen.route){
            HomeScreenHai()
        }

        composable(Screens.Screen2.route){
            Screen2()
        }

        composable(Screens.Screen3.route){
            Screen3()
        }

        composable(Screens.Screen4.route){
            Screen4()
        }
    }
}

@Composable
fun HomeScreenHai(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Text("Screen 1")
    }
}

@Composable
fun Screen2(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Text("Screen 2")
    }
}

@Composable
fun Screen3(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Text("Screen 3")
    }
}


@Composable
fun Screen4(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Text("Screen 4")
    }
}