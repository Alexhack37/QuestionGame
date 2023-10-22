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
        composable(
            route = Screen.Category.route
        ){
            //CountDownScreen(navController = navController)
        }
        composable(
            route = Screen.CountDownScreen.route
        ){
            //CountDownScreen(navController = navController)
        }
        composable(
            route = Screen.Questions.route
        ){
            Options(navController= navController)
        }
    }
}
// pon un compensable por tu pantalla
//4 copia la funcion preview que tiene el navcontroller (de  Home.kt ejemplo) pegala abajo de tu
// nuevo .kt y aniade navController: NavController a tu formula (normalmente la de arriba que no tiene preivew) en los atributos