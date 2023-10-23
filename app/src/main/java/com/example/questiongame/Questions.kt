package com.example.questiongame

import android.graphics.BitmapFactory.Options
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.questiongame.ui.theme.CountDownTimerViewModel

data class Option(val text: String, val isCorrect: Boolean)

data class Question(val text: String, val options: List<Option>)


var total =0

@Composable
fun QuestionScreen(
    navController: NavController,
    viewModel: CountDownTimerViewModel = viewModel()) {



    val questions = listOf(
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
    var currentQuestion by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf<Option?>(null) }

    //FLECHA ATRAS
    Column {
        Button(onClick = {  navController.navigate(route = Screen.Home.route)}) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null
            )
        }

    }

    //TIMER
    Column (
        modifier = Modifier
            .fillMaxSize()
            .offset(y = (60).dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        viewModel.apply {
            Text(text = timerText.value, fontSize = 28.sp)
            startCountDownTimer(navController)

        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        verticalArrangement = Arrangement.Center
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

            var message by remember { mutableStateOf<String?>(null) }
            Button(
                onClick = {
                    // Procesa la respuesta y pasa a la siguiente pregunta
                    if (selectedOption != null) {
                        val isCorrect = selectedOption!!.isCorrect // Comprueba si la opción seleccionada es correcta
                        if (isCorrect) {
                            message = "Correcto!"
                            total++

                        } else {
                            message = "Incorrecto"
                            total+=0
                            // La opción seleccionada es incorrecta, puedes mostrar un mensaje de "Incorrecto".
                        }
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

            // Mostrar el mensaje en la interfaz de usuario
            message?.let {
                Text(
                    text = it,
                    fontSize = 50.sp,
                    modifier = Modifier.padding(top = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

        } else {
            // Muestra un mensaje o pantalla de finalización
            Text(text = "total points $total")
            total =0
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuestionPreview() {

    QuestionScreen(navController = rememberNavController())

}
