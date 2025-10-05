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
                onClick = { name ->
                    navController.navigate(Screens.SecondScreen.createRoute(name = name))
                }
            )
        }

        composable(Screens.SecondScreen.route) {backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            SecondScreens(
                onClick = {
                    navController.navigate(Screens.ThirdScreen.route)
                },
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