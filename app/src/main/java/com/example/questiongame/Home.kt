package com.example.questiongame

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun TituloJuego(
    navController: NavController //aniadir esto para cuando quiero moverme a otra pantalla
) {



    Box(
        modifier = Modifier.fillMaxSize().offset(y = (50).dp),
        contentAlignment = Alignment.TopCenter

    ){
        Text(
            //SI A;ANDISTE TU NUEVA POANTALLA EN SCREEN.KT PUEDES PONER UN MODIFIER AL ELEMENTO
            //PARA QUIE SEA CLICLEABE Y PODER IR A LA PANTALLA EN ESTE CASO SECONDCREEN
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.SecondScreen.route) //AQUI TE VAS
            },
            text = "Askers!",
            color = Color.Red,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Button(

            onClick = {
                navController.navigate(route = Screen.SecondScreen.route)
            }) {
            Text(
                text = "Jugar",
                color = Color.Red,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun GreetingPreview(

) {
    TituloJuego(
        navController = rememberNavController() //para moverte pantalla
    )

}
