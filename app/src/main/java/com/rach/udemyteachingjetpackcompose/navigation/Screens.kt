package com.rach.udemyteachingjetpackcompose.navigation

sealed class Screens(val route: String) {
    object FirstScreen: Screens("FirstScreen")
    object SecondScreen: Screens("SecondScreen")
    object ThirdScreen : Screens("ThirdScreen")
}