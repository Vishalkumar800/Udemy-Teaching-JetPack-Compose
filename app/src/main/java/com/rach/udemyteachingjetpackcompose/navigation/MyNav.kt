package com.rach.udemyteachingjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNav() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.FirstScreen.route
    ) {
        composable(Screens.FirstScreen.route) {
            FirstScreens(
                navController = navController
            )
        }

        composable(Screens.SecondScreen.route) {backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            SecondScreens(
                name = name
            )
        }

        composable(Screens.ThirdScreen.route) {
            ThirdScreens(
                onClick = {
                    navController.navigate(Screens.FirstScreen.route)
                }
            )
        }
    }
}