package com.example.questiongame

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SecondScreen(

    navController: NavController
){
    Box {
        Text(
            modifier = Modifier.clickable {
                //navController.navigate(route = Screen.Home.route)
                navController.popBackStack() //AQUI TE VAS
            },
            text = "Volver",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
    Box(
        modifier = Modifier.fillMaxSize().offset(y = (70).dp), //positivo hacia abajo
        contentAlignment = Alignment.TopCenter
    ){
        Button(

            onClick = {
                navController.navigate(route = Screen.Category.route)
            }) {
            Text(
                text = "Jugar",
                color = Color.White,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxSize().offset(y = (150).dp), //positivo hacia abajo
        contentAlignment = Alignment.TopCenter
    ){
        Button(

            onClick = {
                Log.d("tag","hola")
                //navController.navigate(route = Screen.SecondScreen.route)
            }) {
            Text(
                text = "Ranking",
                color = Color.Red,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondSceenPreview() {
    SecondScreen(
        navController = rememberNavController()
    )
}