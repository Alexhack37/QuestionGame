package com.example.questiongame

import android.graphics.drawable.Icon
import androidx.compose.material3.Surface



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun Options(navController: NavController){

    Column {
        Button(onClick = {  navController.navigate(route = Screen.Home.route)}) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null
            )
        }

    }
    Box(
        modifier = Modifier.fillMaxSize().offset(y = (70).dp), //positivo hacia abajo
        contentAlignment = Alignment.TopCenter,


        ) {


        Text("En Stranger Things, ¿qué criatura aterradora acecha la ciudad de Hawkins?", fontSize = 20.sp,)
        Button(onClick = { /*TODO*/ }, Modifier.padding(top = 150.dp),colors=ButtonDefaults.buttonColors(containerColor = Color.Green),shape= RoundedCornerShape(20.dp)){

            Text("Opcion1",
                fontSize = 50.sp
            )
            //Spacer(modifier = Modifier.width(8.dp)), HUECO ENTRE ICONO Y TEXTO
            //Icon(imageVector = Icons.Default.Search, contentDescription = null
        }
        Button(onClick = { /*TODO*/ }, Modifier.padding(top = 300.dp),colors=ButtonDefaults.buttonColors(containerColor = Color.Red)){
            Text("Opcion2",
                fontSize = 50.sp)
        }

        Button(onClick = { /*TODO*/ }, Modifier.padding(top = 450.dp),colors=ButtonDefaults.buttonColors(containerColor = Color.Blue)){
            Text("Opcion3",
                fontSize = 50.sp)
        }
        Button(onClick = { /*TODO*/ }, Modifier.padding(top = 600.dp),colors=ButtonDefaults.buttonColors(containerColor = Color.Yellow)){
            Text("Opcion4",
                fontSize = 50.sp)
        }
    }


}
@Preview(showBackground = true)
@Composable
fun QuestionPreview() {

    Options(
        navController = rememberNavController()
    )
}
