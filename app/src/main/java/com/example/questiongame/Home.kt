package com.example.questiongame

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun TituloJuego(
    //backgroundImage: Painter,
    navController: NavController //aniadir esto para cuando quiero moverme a otra pantalla
) {

    Box(
        modifier = Modifier.fillMaxSize()
            .offset(y = (150).dp),
        contentAlignment = Alignment.TopCenter

    ){
        Text(
            //SI A;ANDISTE TU NUEVA POANTALLA EN SCREEN.KT PUEDES PONER UN MODIFIER AL ELEMENTO
            //PARA QUIE SEA CLICLEABE Y PODER IR A LA PANTALLA EN ESTE CASO SECONDCREEN
            /*modifier = Modifier.clickable {
                navController.navigate(route = Screen.SecondScreen.route) //AQUI TE VAS
            },*/
                text = "Askers!",
                color = Color.Red,
                fontSize = 85.sp,
                fontWeight = FontWeight.Bold
            )
    }

    Box(
        modifier = Modifier.fillMaxSize()
        .offset(y = (150).dp),
        contentAlignment = Alignment.Center

    ){
        Text(
            text = "Toca la Pantalla",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
    Column(
        modifier = Modifier.fillMaxSize().offset(y = (-60).dp)

            .clickable { navController.navigate(route = Screen.SecondScreen.route) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,

    ) {

        Text(
            text = "URJC 2023",
            color = Color.Red,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Alejandro Cavero, Daniel Gárate, Javier Barriga, Daniel Capilla, Álvaro Lozano, Luis Mateos",
            color = Color.Red,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            textAlign = TextAlign.Center,
            modifier = Modifier
                    .padding(25.dp)
                    .offset(y = (15).dp),
        )
    }

}


@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    //val backgroundImage: Painter = painterResource(id = R.drawable.background_image)
    TituloJuego(
        //backgroundImage,
        navController = rememberNavController() //para moverte pantalla
    )

}
