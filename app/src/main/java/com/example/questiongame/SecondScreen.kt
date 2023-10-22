package com.example.questiongame


import android.graphics.drawable.Icon

import android.util.Log

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon

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
) {
    Column {

        Button(onClick = { navController.navigate(route = Screen.Home.route) }) {
            Icon(
                Icons.Default.Home,
                contentDescription = null
            )
        }



        Box(
            modifier = Modifier.fillMaxSize().offset(y = (70).dp), //positivo hacia abajo
            contentAlignment = Alignment.TopCenter
        ) {
            Button(

                onClick = {
                    navController.navigate(route = Screen.Questions.route)
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
        ) {
            Button(

                onClick = {
                    Log.d("tag", "hola")
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
}

@Preview(showBackground = true)
@Composable
fun SecondSceenPreview() {
    SecondScreen(
        navController = rememberNavController()
    )
}