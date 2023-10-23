package com.example.questiongame

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Button(onClick = {
            navController.navigate(route = Screen.Questions.route)
        }, Modifier.padding(top = 200.dp)){
            Text("PELICULAS",
                    fontSize = 50.sp
            )
            //Spacer(modifier = Modifier.width(8.dp)), HUECO ENTRE ICONO Y TEXTO
            //Icon(imageVector = Icons.Default.Search, contentDescription = null
        }
            Button(onClick = {
                navController.navigate(route = Screen.QuestionsTV.route)
            }, Modifier.padding(top = 375.dp)){
                Text("SERIES",
                    fontSize = 50.sp)
            }

        Button(onClick = {
            navController.navigate(route = Screen.QuestionsBook.route)
        }, Modifier.padding(top = 550.dp)){
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
