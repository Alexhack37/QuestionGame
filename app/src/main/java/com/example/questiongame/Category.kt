package com.example.questiongame

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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

//import com.google.android.gms.wallet.button.ButtonConstants


@Composable
fun CategorySelector(
    modifier : Modifier = Modifier,
    navController: NavController
){
    Button(onClick = { navController.navigate(route = Screen.Home.route) }) {
        Icon(
            Icons.Default.Home,
            contentDescription = null
        )
    }

    Box(
        modifier = Modifier.fillMaxSize()
            .offset(y = (150).dp),
        contentAlignment = Alignment.TopCenter

    ) {
        Text(
            text = "Askers!",
            color = Color.Red,
            fontSize = 85.sp,
            fontWeight = FontWeight.Bold
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Button(onClick = {
            navController.navigate(route = Screen.Questions.route)
        }, Modifier.padding(top = 340.dp)){
            Text("  CINE  ",
                    fontSize = 50.sp
            )
            //Spacer(modifier = Modifier.width(8.dp)), HUECO ENTRE ICONO Y TEXTO
            //Icon(imageVector = Icons.Default.Search, contentDescription = null
        }
            Button(onClick = {
                navController.navigate(route = Screen.QuestionsTV.route)
            }, Modifier.padding(top = 495.dp)){
                Text("SERIES",
                    fontSize = 50.sp)
            }

        Button(onClick = {
            navController.navigate(route = Screen.QuestionsBook.route)
        }, Modifier.padding(top = 650.dp)){
            Text("LIBROS",
                fontSize = 50.sp)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun CategorySelectorPreview(

) {
    CategorySelector(
        navController = rememberNavController() //para moverte pantalla
    )
}
