package com.example.questiongame

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.questiongame.ui.theme.CountDownTimerViewModel
import com.example.questiongame.ui.theme.restTime
import kotlin.math.absoluteValue


@Composable
fun PuntuationScreen(
    modifier : Modifier = Modifier,
    navController: NavController
    ) {
    Column {
        Button(onClick = {
            total=0
            cont=0
            contBooks=0
            contSeries=0
            visit.clear()
            visitBooks.clear()
            visitTV.clear()
            navController.navigate(route = Screen.Home.route) }) {
            Icon(
                Icons.Default.Home,
                contentDescription = null
            )
    }

    }
    var numOfPoints by remember  { mutableStateOf(0) }
    var rest=(restTime.toInt()/1000)
    numOfPoints=total* (restTime.toInt()/1000)+total*2
    Box(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = (150).dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = " ACIERTOS $total",
            color = Color.Black,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier=Modifier.padding(top = 100.dp),
            text = " TIEMPO  $rest",
            color = Color.Black,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier=Modifier.padding(top = 200.dp),
            text = "  PUNTOS $numOfPoints",
            color = Color.Black,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )



        Button(onClick = {

            navController.navigate(route = Screen.Category.route)
            total=0
            cont=0
            contBooks=0
            contSeries=0
            visit.clear()
            visitBooks.clear()
            visitTV.clear()
        }, Modifier.padding(top = 450.dp)) {
            Text(
                "VOLVER A JUGAR",
                fontSize = 35.sp
            )

        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun PuntuationScreenPreview() {
    PuntuationScreen(
        navController = rememberNavController() //para moverte pantalla
    )

}