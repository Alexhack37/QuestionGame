package com.example.questiongame

sealed class Screen(val route: String){
    object Home: Screen(route = "home_Screen")
    object SecondScreen: Screen(route = "second_Screen")
    object Category: Screen(route = "Category_Screen")
    object CountDownScreen: Screen(route = "CountDownScreen_Screen")
}
//2 aniade tu screen aqui y vete a Navgraph.kt
