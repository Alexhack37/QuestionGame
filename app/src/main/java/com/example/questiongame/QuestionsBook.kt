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

data class OptionBooks(val text: String, val isCorrect: Boolean)

data class QuestionBooks(val text: String, val options: List<Option>)


val visitBooks= mutableListOf<Int>()
var randomBooks=Random.nextInt(0,11)
var contBooks=0

@Composable
fun TimerBooks(
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
fun QuestionScreenBooks(
    navController: NavController,
    viewModel: CountDownTimerViewModel = viewModel()) {



    val questions = listOf(
        // Aquí deberías tener tus preguntas cargadas desde el archivo XML
        Question("¿Quién escribió '1984', una novela distópica sobre un estado totalitario?", listOf(
            Option("a) George Orwell", true),
            Option("b) Aldous Huxley", false),
            Option("c) Ray Bradbury", false),
            Option("d) Philip K. Dick", false)
        )),
        Question("¿Quién es el autor de la serie de libros 'Canción de hielo y fuego'?", listOf(
            Option("a) J.R.R. Tolkien", false),
            Option("b) Stephen King", false),
            Option("c) George R.R. Martin", true),
            Option("d) J.K. Rowling", false)
        )),
        Question("¿Qué libro cuenta la historia de un hombre que se despierta un día como un insecto gigante?", listOf(
            Option("a) Crimen y castigo", false),
            Option("b) La naranja mecánica", false),
            Option("c) Metamorfosis", true),
            Option("d) Cien años de soledad", false)
        )),
        Question("¿Cuál de los siguientes libros es una obra de Jane Austen?", listOf(
            Option("a) Cumbres Borrascosas", false),
            Option("b) Orgullo y prejuicio", true),
            Option("c) Matar un ruiseñor", false),
            Option("d) Mujercitas", false)
        )),
        Question("¿Quién escribió 'Matar un ruiseñor', una novela que aborda temas de raza y justicia en el sur de Estados Unidos?", listOf(
            Option("a) Charles Dickens", false),
            Option("b) Harper Lee", true),
            Option("c) F. Scott Fitzgerald", false),
            Option("d) Mark Twain", false)
        )),
        Question("¿En qué libro un grupo de niños se encuentra atrapado en una isla desierta después de un accidente de avión?", listOf(
            Option("a) Las Crónicas de Narnia: El león, la bruja y el armario", false),
            Option("b) Señor de las Moscas", true),
            Option("c) El Hobbit", false),
            Option("d) Veinte mil leguas de viaje submarino", false)
        )),
        Question("¿Quién escribió 'Los pilares de la Tierra', una novela histórica ambientada en la Edad Media?", listOf(
            Option("a) Ken Follett", true),
            Option("b) George R.R. Martin", false),
            Option("c) J.K. Rowling", false),
            Option("d) Dan Brown", false)
        )),
        Question("¿Quién es el autor de 'La Odisea', una epopeya clásica griega que narra el regreso de Ulises a Ítaca?", listOf(
            Option("a) Homero", true),
            Option("b) Sófocles", false),
            Option("c) Esquilo", false),
            Option("d) Aristóteles", false)
        )),
        Question("¿Quién escribió 'El Gran Gatsby', una novela que critica la sociedad estadounidense en la década de 1920?", listOf(
            Option("a) Ernest Hemingway", false),
            Option("b) F. Scott Fitzgerald", true),
            Option("c) John Steinbeck", false),
            Option("d) Mark Twain", false)
        ))



        // Agrega más preguntas aquí
    )
    var currentQuestionBooks by remember { mutableStateOf(0) }
    var selectedOptionBooks by remember { mutableStateOf<Option?>(null) }

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
        if (contBooks< 10) {
            val question = questions[randomBooks]
            Box(){
                Text(text = question.text, style = MaterialTheme.typography.bodySmall)
            }

            Spacer(modifier = Modifier.height(16.dp))
            question.options.forEach { option ->
                RadioButton(
                    selected = option == selectedOptionBooks,
                    onClick = { selectedOptionBooks = option },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = option.text,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { selectedOptionBooks = option }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            var message by remember { mutableStateOf<String?>(null) }
            Button(
                onClick = {
                    // Procesa la respuesta y pasa a la siguiente pregunta
                    if (selectedOptionBooks != null) {
                        val isCorrect = selectedOptionBooks!!.isCorrect // Comprueba si la opción seleccionada es correcta
                        if (isCorrect) {
                            total++


                        } else {
                            total+=0
                            // La opción seleccionada es incorrecta, puedes mostrar un mensaje de "Incorrecto".
                        }
                        visitBooks.add(randomBooks)
                        randomBooks= Random.nextInt(0,10)
                        while(visit.contains(randomBooks)){
                            randomBooks= Random.nextInt(0,10)
                        }

                        reset = 1
                        selectedOptionBooks = null
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
            navController.navigate(route = Screen.PuntuationScreen.route)
        }

    }

}


@Preview(showBackground = true)
@Composable
fun QuestionPreviewBooks() {

    QuestionScreenBooks(navController = rememberNavController())
    TimerBooks(navController = rememberNavController())

}


