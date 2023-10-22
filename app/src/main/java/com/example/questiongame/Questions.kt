package com.example.questiongame

import android.graphics.drawable.Icon
import androidx.compose.material3.Surface



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.RadioButton
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.questiongame.ui.theme.CountDownTimerViewModel
import java.io.BufferedReader
import java.io.File

data class Option(val text: String, val isCorrect: Boolean)

data class Question(val text: String, val options: List<Option>)

@Composable
fun QuestionScreen(questions: List<Question>,navController: NavController) {
    var currentQuestion by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf<Option?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        if (currentQuestion < questions.size) {
            val question = questions[currentQuestion]
            Box(){
                Text(text = question.text, style = MaterialTheme.typography.bodySmall)
            }

            Spacer(modifier = Modifier.height(16.dp))
            question.options.forEach { option ->
                RadioButton(
                    selected = option == selectedOption,
                    onClick = { selectedOption = option },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = option.text,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { selectedOption = option }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // Procesa la respuesta y pasa a la siguiente pregunta
                    if (selectedOption != null) {
                        // Aquí puedes realizar la lógica de puntuación o procesamiento
                        currentQuestion++
                        selectedOption = null
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text ="Siguiente")
            }
        } else {
            // Muestra un mensaje o pantalla de finalización
            Text(text = "U won")
        }
    }
}


//@Composable





@Composable
fun Options(
    navController: NavController,
    viewModel: CountDownTimerViewModel = viewModel()
){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        viewModel.apply {
            Text(text = timerText.value, fontSize = 28.sp)
            startCountDownTimer(navController)

        }
    }

    //-------------------javi----------------------
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


        //Text("En Stranger Things, ¿qué criatura aterradora acecha la ciudad de Hawkins?", fontSize = 20.sp,)
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

    val questionsList = listOf(
        // Aquí deberías tener tus preguntas cargadas desde el archivo XML
        Question("¿Quién dirigió la película 'Pulp Fiction' en 1994?", listOf(
            Option("a) Quentin Tarantino", true),
            Option("b) Martin Scorsese", false),
            Option("c) Steven Spielberg", false),
            Option("d) Christopher Nolan", false)
        )),
        Question("Which actor portrayed the character Jack Dawson in the 1997 film 'Titanic'?", listOf(
            Option("a) Leonardo DiCaprio", true),
            Option("b) Tom Hanks", false),
            Option("c) Johnny Depp", false),
            Option("d) Brad Pitt", false)
        ))

        // Agrega más preguntas aquí
    )

    QuestionScreen(questionsList,navController = rememberNavController())
    Options(
        navController = rememberNavController()
    )
}
