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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.questiongame.ui.theme.CountDownTimerViewModel
import kotlin.random.Random

data class Option(val text: String, val isCorrect: Boolean)

data class Question(val text: String, val options: List<Option>)


var total =0
var reset =0
var random=Random.nextInt(0,11)
var cont=0
val visit= mutableListOf<Int>()

@Composable
fun Timer(
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
        Question("¿Quién interpreta a Jack Dawson en la película 'Titanic'?", listOf(
            Option("a) Leonardo DiCaprio", true),
            Option("b) Tom Hanks", false),
            Option("c) Johnny Depp", false),
            Option("d) Brad Pitt", false)
        )),
        Question("¿Quién interpreta a James Bond en la película 'Casino Royale'?", listOf(
            Option("a) Sean Connery", false),
            Option("b) Pierce Brosnan", false),
            Option("c) Daniel Craig", true),
            Option("d) Roger Moore", false)
        )),
        Question("¿Cuál de las siguientes películas es una obra de ciencia ficción dirigida por Ridley Scott?", listOf(
            Option("a) The Silence of the Lambs", false),
            Option("b) Blade Runner", true),
            Option("c) The Godfather", false),
            Option("d) Schindler's List", false)
        )),
        Question("¿Quién dirigió la película 'El Padrino'?", listOf(
            Option("a) Martin Scorsese", false),
            Option("b) Quentin Tarantino", false),
            Option("c) Francis Ford Coppola", true),
            Option("d) Alfred Hitchcock", false)
        )),
        Question("¿Quién interpreta a Tony Stark en el Universo Cinematográfico de Marvel (MCU)?", listOf(
            Option("a) Chris Hemsworth", false),
            Option("b) Robert Downey Jr.", true),
            Option("c) Chris Evans", false),
            Option("d) Mark Ruffalo", false)
        )),
        Question("¿Cuál de las siguientes películas es una comedia de ciencia ficción que parodia la cultura geek y los videojuegos?", listOf(
            Option("a) Scott Pilgrim vs. the World", true),
            Option("b) Inception", false),
            Option("c) Blade Runner", false),
            Option("d) The Dark Knight", false)
        )),
        Question("¿Quién interpretó a Frodo Bolsón en la trilogía de 'El Señor de los Anillos'?", listOf(
            Option("a) Elijah Wood", true),
            Option("b) Ian McKellen", false),
            Option("c) Viggo Mortensen", false),
            Option("d) Orlando Bloom", false)
        )),
        Question("¿Quién dirigió la película 'Parasite', que ganó el Premio de la Academia a la Mejor Película en 2020?", listOf(
            Option("a) Bong Joon-ho", true),
            Option("b) Park Chan-wook", false),
            Option("c) Kim Ki-duk", false),
            Option("d) Hong Sang-soo", false)
        )),
        Question("¿Quién interpreta a Katniss Everdeen en la serie de películas 'Los juegos del hambre'?", listOf(
            Option("a) Jennifer Aniston", false),
            Option("b) Scarlett Johansson", false),
            Option("c) Jennifer Lawrence", true),
            Option("d) Anne Hathaway", false)
        )),
        Question("¿Quién interpreta a Neo en la película 'The Matrix'?", listOf(
            Option("a) Keanu Reeves", true),
            Option("b) Laurence Fishburne", false),
            Option("c) Hugo Weaving", false),
            Option("d) Tom Hanks", false)
        )),
        Question("¿Cuál de las siguientes películas es una película de terror sobre un asesino enmascarado llamado Michael Myers?", listOf(
            Option("a) A Nightmare on Elm Street", false),
            Option("b) Friday the 13th", false),
            Option("c) Halloween", true),
            Option("d) The Exorcist", false)
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


    Column(
        modifier = Modifier
            .padding(20.dp)
            .offset(y = (90).dp),
        verticalArrangement = Arrangement.Top,

        ) {
        if (cont< 10) {
            val question = questions[random]
            Box(){
                Text(text = question.text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }


            Spacer(modifier = Modifier.height(16.dp))
            question.options.forEach { option ->
                Text(
                    text = option.text,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp,
                    letterSpacing = MaterialTheme.typography.titleLarge.letterSpacing,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { selectedOption = option }
                        .offset(y = (20).dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "",
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { selectedOption = option }
                        .offset(y = (1).dp)
                        .align(Alignment.CenterHorizontally)
                )

                RadioButton(
                    selected = option == selectedOption,
                    onClick = { selectedOption = option },
                    modifier = Modifier.fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
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
                            total++



                        } else {
                            total+=0
                            // La opción seleccionada es incorrecta, puedes mostrar un mensaje de "Incorrecto".
                        }
                        visit.add(random)
                        random= Random.nextInt(0,11)
                        while(visit.contains(random)){
                            random= Random.nextInt(0,11)
                        }



                        reset = 1
                        cont+=1
                        selectedOption = null
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
fun QuestionPreview() {

    QuestionScreen(navController = rememberNavController())
    Timer(navController = rememberNavController())

}
