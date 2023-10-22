package com.example.questiongame

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SecondScreen(

    navController: NavController
){
    Column {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Home.route) //AQUI TE VAS
            },
            text = "Volver",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable {
                //navController.navigate(route = Screen.Home.route){   AQUI TE VAS
                // popUpTp(Screen.Home.route){inclusive = true} //flecah de android me permite volver excepto si estoy en Hom scren que si no me salgo al escritorio android
                //}
                navController.popBackStack() //para no volver desde home con la felcha atras del movil
            },
            text = "SegundaPantalla",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondSceenPreview() {
    SecondScreen(
        navController = rememberNavController()
    )
}