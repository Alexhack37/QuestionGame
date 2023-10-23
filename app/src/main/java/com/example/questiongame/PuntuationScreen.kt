package com.example.questiongame

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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


@Composable
fun PuntuationScreen(
    modifier : Modifier = Modifier,
    navController: NavController
    ) {
    var numOfPoints by remember  { mutableStateOf(0) }
    Box(
        modifier = Modifier.fillMaxSize()
            .offset(y = (150).dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = " YOU GET \n$numOfPoints POINTS",
            color = Color.Black,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )


        Button(onClick = {
            //navController.navigate(route = Screen.Question.route)
        }, Modifier.padding(top = 450.dp)) {
            Text(
                "Play Again",
                fontSize = 40.sp
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