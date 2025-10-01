package com.rach.udemyteachingjetpackcompose.navigation

sealed class Screens(val route: String) {
    object FirstScreen: Screens("FisrtScreen")
    object SecondScreen: Screens("SecondScreen")
    object ThirdScreen : Screens("ThirdScreen")
}