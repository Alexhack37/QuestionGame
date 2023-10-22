package com.example.questiongame

sealed class Screen(val route: String){
    object Home: Screen(route = "home_Screen")
    object SecondScreen: Screen(route = "second_Screen")
}
