package com.example.questiongame

import android.graphics.BitmapFactory.Options
import android.net.Uri
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

data class OptionTV(val text: String, val isCorrect: Boolean)

data class QuestionTV(val text: String, val options: List<Option>)



val visitTV= mutableListOf<Int>()
var randomSeries= 30
var contSeries=0
val videoUriSeries = Uri.parse("android.resource://com.example.questiongame/raw/video3")
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
            Option("c) Bajo escucha", false),
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
        )),
        Question("En 'Fargo', ¿cuál es el nombre del personaje interpretado por Billy Bob Thornton", listOf(
            Option("a) Lorne Malvo", true),
            Option("b) Lester Nygaard", false),
            Option("c) Molly Solverson", false),
            Option("d) Jerry Lundegaard", false)
        )),
        Question("En 'Westworld', ¿cuál es el nombre del creador del parque de atracciones con anfitriones robóticos?", listOf(
            Option("a) Dr. Ford", true),
            Option("b) Bernard Lowe", false),
            Option("c) William", false),
            Option("d) Teddy Flood", false)
        )),
        Question("En 'Sherlock', ¿quién interpreta al genio detective Sherlock Holmes?", listOf(
            Option("a) Martin Freeman", false),
            Option("b) David Tennant", false),
            Option("c) Benedict Cumberbatch", true),
            Option("d) Tom Hiddleston", false)
        )),
        Question("En 'Bajo escucha', ¿cuál es el nombre del detective interpretado por Idris Elba que se involucra en el tráfico de drogas?", listOf(
            Option("a) Lester Freamon", false),
            Option("b) Jimmy McNulty", false),
            Option("c) Stringer Bell", true),
            Option("d) Avon Barksdale", false)
        )),
        Question("En 'Battlestar Galactica', ¿cuál es el nombre de la nave espacial que se convierte en la última esperanza de la humanidad?", listOf(
            Option("a) Galactica", true),
            Option("b) Pegasus", false),
            Option("c) Prometheus", false),
            Option("d) Viper", false)
        )),
        Question("En 'Boardwalk Empire', ¿quién interpreta al político corrupto y contrabandista Enoch 'Nucky' Thompson?", listOf(
            Option("a) Steve Buscemi", true),
            Option("b) Michael Pitt", false),
            Option("c) Michael Shannon", false),
            Option("d) Jack Huston", false)
        )),
        Question("En 'Mad Men', ¿cuál es el nombre del carismático publicista interpretado por Jon Hamm?", listOf(
            Option("a) Don Draper", true),
            Option("b) Roger Sterling", false),
            Option("c) Pete Campbell", false),
            Option("d) Joan Holloway", false)
        )),
        Question("En 'Mr. Robot', ¿cuál es el nombre del personaje interpretado por Rami Malek?", listOf(
            Option("a) Elliot Alderson", true),
            Option("b) Tyler Durden", false),
            Option("c) Tyrell Wellick", false),
            Option("d) Whiterose", false)
        )),
        Question("En 'The Leftovers', ¿qué evento masivo y misterioso desaparece al 2% de la población mundial?", listOf(
            Option("a) El Rapture", false),
            Option("b) La Gran Desaparición", false),
            Option("c) La Purga", false),
            Option("d) El Gran Despertar", true)
        )),
        Question("En 'Orphan Black', ¿cuál es el nombre de la actriz que interpreta a múltiples clones idénticos con personalidades diferentes?", listOf(
            Option("a) Tatiana Maslany", true),
            Option("b) Sarah Paulson", false),
            Option("c) Elisabeth Moss", false),
            Option("d) Claire Danes", false)
        )),
        Question("En 'Hannibal', ¿cuál es el nombre del famoso psiquiatra y asesino en serie, interpretado por Mads Mikkelsen?", listOf(
            Option("a) Hannibal Lecter", true),
            Option("b) Dexter Morgan", false),
            Option("c) Frankenstein", false),
            Option("d) Sherlock Holmes", false)
        )),
        Question("En 'Dark', ¿cuál es el nombre del ciclo que afecta a la ciudad de Winden y a sus habitantes?", listOf(
            Option("a) El Ciclo Eterno", false),
            Option("b) El Ciclo Infinito", false),
            Option("c) El Ciclo de la Paradoja", false),
            Option("d) El Ciclo del Tiempo", true)
        )),
        Question("En 'Mindhunter', ¿cuál es el nombre del agente del FBI que se especializa en psicología criminal?", listOf(
            Option("a) Holden Ford", true),
            Option("b) Bill Tench", false),
            Option("c) Wendy Carr", false),
            Option("d) Ed Kemper", false)
        )),
        Question("En 'Ozark', ¿qué familia se traslada a un oscuro mundo de lavado de dinero para un cartel de drogas mexicano?", listOf(
            Option("a) Los Smith", false),
            Option("b) Los Johnson", false),
            Option("c) Los Byrde", true),
            Option("d) Los Williams", false)
        )),
        Question("En 'Peaky Blinders', ¿cuál es el nombre del líder de la familia Shelby, interpretado por Cillian Murphy?", listOf(
            Option("a) Thomas Shelby", true),
            Option("b) Arthur Shelby", false),
            Option("c) John Shelby", false),
            Option("d) Michael Shelby", false)
        )),
        Question("En 'True Detective', ¿cuál es el título del primer episodio de la primera temporada?", listOf(
            Option("a) 'The King in Yellow'", false),
            Option("b) 'The Long Bright Dark'", true),
            Option("c) 'The Secret Fate of All Life'", false),
            Option("d) 'Form and Void'", false)
        )),
        Question("En 'The Americans', ¿cuál es el nombre en clave de la operación de espionaje que realizan Philip y Elizabeth Jennings?", listOf(
            Option("a) Operación Rusa", false),
            Option("b) Operación Venganza", false),
            Option("c) Operación Chicago", false),
            Option("d) Operación Jennifer", true)
        )),
        Question("En 'The Expanse', ¿cuál es el nombre del planeta colonizado por la humanidad que desencadena una guerra interestelar?", listOf(
            Option("a) Marte", false),
            Option("b) La Luna", false),
            Option("c) Ganímedes", false),
            Option("d) Ilus", true)
        )),
        Question("En 'Mindhunter', ¿cuál es el nombre del asesino en serie que es entrevistado por los agentes del FBI y es conocido por su apodo 'El Estrangulador de Co-Ed'?", listOf(
            Option("a) Ed Kemper", false),
            Option("b) Richard Ramirez", false),
            Option("c) Jerry Brudos", false),
            Option("d) Edmund Kemper", true)
        )),
        Question("En 'El cuento de la criada', ¿cuál es el nombre del comandante interpretado, quien está casado con Serena Joy?", listOf(
            Option("a) Comandante Waterford", true),
            Option("b) Comandante Lawrence", false),
            Option("c) Comandante Winslow", false),
            Option("d) Comandante Blaine", false)
        )),
        Question("En 'Doctor Who', ¿cuál es el nombre de la raza  que son enemigos recurrentes del Doctor y están encerrados en armaduras de metal?", listOf(
            Option("a) Time Lords", false),
            Option("b) Silurians", false),
            Option("c) Weeping Angels", false),
            Option("d) Daleks", true)
        )),
        Question("¿De qué serie es esta escena?", listOf(
            Option("a) Ed Sheeran: Compositor", false),
            Option("b) Juego de Tronos", true),
            Option("c) The Witcher", false)
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
            .padding(20.dp)
            .offset(y = (90).dp),
        verticalArrangement = Arrangement.Top,

        ) {
        if (contSeries < 10) {
            val question = questions[randomSeries]
            Box(){
                Text(text = question.text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
            if(randomSeries == questions.size-1)
            {
                VideoPlayer(videoUri = videoUriSeries)
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
                        .clickable { selectedOptionTv = option }
                        .offset(y = (20).dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "",
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { selectedOptionTv = option }
                        .offset(y = (1).dp)
                        .align(Alignment.CenterHorizontally)
                )

                RadioButton(
                    selected = option == selectedOptionTv,
                    onClick = { selectedOptionTv = option },
                    modifier = Modifier.fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
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
                        randomSeries= Random.nextInt(0,30)
                        while(visitTV.contains(randomSeries)){
                            randomSeries= Random.nextInt(0,30)
                        }
                        contSeries+=1
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
