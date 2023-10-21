package com.example.questiongame

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SetUpNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            TituloJuego(navController = navController)
        }

        composable(
            route = Screen.SecondScreen.route
        ){
            SecondScreen(navController = navController)
        }
    }
}