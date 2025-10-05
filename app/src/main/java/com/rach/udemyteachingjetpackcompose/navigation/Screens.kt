package com.rach.udemyteachingjetpackcompose.navigation

sealed class Screens(val route: String) {
    object FirstScreen: Screens("FirstScreen")
    object SecondScreen: Screens("SecondScreen/{name}"){
        fun createRoute(name: String) = "SecondScreen/$name"
    }
    object ThirdScreen : Screens("ThirdScreen")
}