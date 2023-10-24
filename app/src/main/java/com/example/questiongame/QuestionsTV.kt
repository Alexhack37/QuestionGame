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
import kotlin.random.Random

data class OptionTV(val text: String, val isCorrect: Boolean)

data class QuestionTV(val text: String, val options: List<Option>)



val visitTV= mutableListOf<Int>()
var randomSeries= Random.nextInt(0,11)
var contSeries=0

@Composable
fun TimerTV(
    viewModel: CountDownTimerViewModel = viewModel(),
    navController: NavController
){
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
            /*
            if(reset > 0){
                stopCountDownTimer()
                //resetCountDownTimer()
            }*/
        }
    }
}

@Composable
fun QuestionScreenTV(
    navController: NavController,
    viewModel: CountDownTimerViewModel = viewModel()) {



    val questions = listOf(
        // Aquí deberías tener tus preguntas cargadas desde el archivo XML
        Question("¿De qué serie es el personaje Walter White?", listOf(
            Option("a) The Office", false),
            Option("b) The Crown", false),
            Option("c) Stranger Things", false),
            Option("d) Breaking Bad", true)
        )),
        Question("¿Quién interpreta a Jon Nieve en la serie Juego de tronos?", listOf(
            Option("a) Kit Harington", true),
            Option("b) Peter Dinklage", false),
            Option("c) Pedro Pascal", false),
            Option("d) Sean Bean", false)
        )),
        Question("¿Cuál de las siguientes series está ambientada en un mundo de fantasía?", listOf(
            Option("a) The Big Bang Theory", false),
            Option("b) Vikingos", false),
            Option("c) El cuento de la criada", true),
            Option("d) Westworld", false)
        )),
        Question("¿En qué serie de ciencia ficción los protagonistas son atrapados en un parque de diversiones futurista?", listOf(
            Option("a) Black Mirror", false),
            Option("b) Perdidos", false),
            Option("c) Westworld", true),
            Option("d) The expanse", false)
        )),
        Question("¿Qué serie de televisión se basa en las novelas de George R. R. Martin?", listOf(
            Option("a) Stranger Things", false),
            Option("b) Juego de Tronos", true),
            Option("c) The walking dead", false),
            Option("d) The Mandalorian", false)
        )),
        Question("¿Cuál de estas series sigue la vida de un narcotraficante?", listOf(
            Option("a) Narcos", true),
            Option("b) Los Soprano", false),
            Option("c) The Wire", false),
            Option("d) Oz", false)
        )),
        Question("¿Qué serie sigue las aventuras de un viajero en el tiempo con una nave espacial llamada TARDIS?", listOf(
            Option("a) Doctor Who", true),
            Option("b) Star Trek", false),
            Option("c) The Expanse", false),
            Option("d) La fundacion", false)
        )),
        Question("¿Qué serie de comedia sigue la vida de un grupo de seis amigos que viven en Nueva York?", listOf(
            Option("a) Seinfield", false),
            Option("b) Friends", true),
            Option("c) Como conoci a vuestra madre", false),
            Option("d) Parks and Recreations", false)
        )),
        Question("¿Cuál de las siguientes series está basada en una historia de superhéroes de DC Comics?", listOf(
            Option("a) The boys", false),
            Option("b) Daredevil", true),
            Option("c) Arrow", false),
            Option("d) Invencible", false)
        ))



        // Agrega más preguntas aquí
    )
    var currentQuestionTv by remember { mutableStateOf(0) }
    var selectedOptionTv by remember { mutableStateOf<Option?>(null) }

    //FLECHA ATRAS
    Column {
        Button(onClick = {  navController.navigate(route = Screen.Home.route)}) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null
            )
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        verticalArrangement = Arrangement.Center
    ) {
        if (contSeries< 10) {
            val question = questions[randomSeries]
            Box(){
                Text(text = question.text, style = MaterialTheme.typography.bodySmall)
            }

            Spacer(modifier = Modifier.height(16.dp))
            question.options.forEach { option ->
                RadioButton(
                    selected = option == selectedOptionTv,
                    onClick = { selectedOptionTv = option },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = option.text,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { selectedOptionTv = option }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            var message by remember { mutableStateOf<String?>(null) }
            Button(
                onClick = {
                    // Procesa la respuesta y pasa a la siguiente pregunta
                    if (selectedOptionTv != null) {
                        val isCorrect = selectedOptionTv!!.isCorrect // Comprueba si la opción seleccionada es correcta
                        if (isCorrect) {
                            total++

                        } else {
                            total+=0
                            // La opción seleccionada es incorrecta, puedes mostrar un mensaje de "Incorrecto".
                        }
                        visitTV.add(randomSeries)
                        randomSeries= Random.nextInt(0,11)
                        while(visitTV.contains(randomSeries)){
                            randomSeries= Random.nextInt(0,11)
                        }
                        reset = 1
                        selectedOptionTv = null
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text ="Siguiente")
                reset = 0
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
            navController.navigate(route = Screen.PuntuationScreen.route)

        }

    }

}


@Preview(showBackground = true)
@Composable
fun QuestionPreviewTV() {

    QuestionScreenTV(navController = rememberNavController())
    TimerTV(navController = rememberNavController())

}
