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

data class OptionBooks(val text: String, val isCorrect: Boolean)

data class QuestionBooks(val text: String, val options: List<Option>)


val visitBooks= mutableListOf<Int>()
var randomBooks=37
var contBooks=0
val videoUriBook = Uri.parse("android.resource://com.example.questiongame/raw/video2")
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
        Question("¿Quién escribió 'Matar un ruiseñor'?", listOf(
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
        Question("¿Quién escribió 'Los pilares de la Tierra'?", listOf(
            Option("a) Ken Follett", true),
            Option("b) George R.R. Martin", false),
            Option("c) J.K. Rowling", false),
            Option("d) Dan Brown", false)
        )),
        Question("¿Quién es el autor de 'La Odisea'?", listOf(
            Option("a) Homero", true),
            Option("b) Sófocles", false),
            Option("c) Esquilo", false),
            Option("d) Aristóteles", false)
        )),
        Question("¿Quién escribió 'El Gran Gatsby'?", listOf(
            Option("a) Ernest Hemingway", false),
            Option("b) F. Scott Fitzgerald", true),
            Option("c) John Steinbeck", false),
            Option("d) Mark Twain", false)
        )),
        Question("¿Quién escribió 'Don Quijote de la Mancha'?", listOf(
            Option("a) Miguel de Cervantes", true),
            Option("b) Gabriel García Márquez", false),
            Option("c) Jorge Luis Borges", false),
            Option("d) William Shakespeare", false)
        )),
        Question("¿Qué novela distópica de Ray Bradbury trata sobre la quema de libros y la censura?", listOf(
            Option("a) '1984'", false),
            Option("b) 'Un Mundo Feliz'", false),
            Option("c) 'Fahrenheit 451'", true),
            Option("d) 'La fundacion'", false)
        )),
        Question("¿Quién es el autor de la serie de libros 'Cazadores de Sombras'?", listOf(
            Option("a) J.K. Rowling", false),
            Option("b) Cassandra Clare", true),
            Option("c) J.R.R. Tolkien", false),
            Option("d) George R.R. Martin", false)
        )),
        Question("¿Qué autor escribió 'Cien años de soledad', una obra clave del realismo mágico?", listOf(
            Option("a) Julio Cortázar", false),
            Option("b) Jorge Luis Borges", false),
            Option("c) Gabriel García Márquez", true),
            Option("d) Mario Vargas Llosa", false)
        )),
        Question("¿Cuál es el título de la primera novela de la saga 'Canción de Hielo y Fuego'?", listOf(
            Option("a) 'Choque de Reyes'", false),
            Option("b) 'Juego de Tronos'", true),
            Option("c) 'Tormenta de Espadas'", false),
            Option("d) 'Festín de Cuervos'", false)
        )),
        Question("¿Quién escribió 'El Hobbit', una novela que se sitúa en la Tierra Media y precede a 'El Señor de los Anillos'?", listOf(
            Option("a) C.S. Lewis", false),
            Option("b) J.K. Rowling", false),
            Option("c) J.R.R. Tolkien", true),
            Option("d) George R.R. Martin", false)
        )),
        Question("¿Cuál es el título del primer libro de la serie 'Crepúsculo' de Stephenie Meyer?", listOf(
            Option("a) 'Crepúsculo'", true),
            Option("b) 'Eclipse'", false),
            Option("c) 'Amanecer'", false),
            Option("d) 'Luna Nueva'", false)
        )),
        Question("¿Qué novela de Charles Dickens cuenta la historia de Ebenezer Scrooge y su transformación en la víspera de Navidad?", listOf(
            Option("a) 'Oliver Twist'", false),
            Option("b) 'Cuento de Navidad'", true),
            Option("c) 'Grandes Esperanzas'", false),
            Option("d) 'David Copperfield'", false)
        )),
        Question("¿Quién es el autor de 'Los juegos del hambre'?", listOf(
            Option("a) Veronica Roth", false),
            Option("b) Suzanne Collins", true),
            Option("c) J.K. Rowling", false),
            Option("d) Stephenie Meyer", false)
        )),
        Question("¿Cuál es el autor de 'En busca del tiempo perdido'?", listOf(
            Option("a) Marcel Proust", true),
            Option("b) Victor Hugo", false),
            Option("c) Gustave Flaubert", false),
            Option("d) Albert Camus", false)
        )),
        Question("¿Qué novela de Fyodor Dostoevsky trata sobre el asesinato de un anciano usurero y las consecuencias psicológicas para el protagonista?", listOf(
            Option("a) 'Crimen y castigo'", true),
            Option("b) 'Los hermanos Karamazov'", false),
            Option("c) 'El idiota'", false),
            Option("d) 'Anna Karénina'", false)
        )),
        Question("¿Cuál es la obra épica que narra la historia de Odiseo y su largo viaje de regreso a casa después de la Guerra de Troya?", listOf(
            Option("a) 'La Eneida'", false),
            Option("b) 'La Ilíada'", false),
            Option("c) 'La Odisea'", true),
            Option("d) 'Antígona'", false)
        )),
        Question("¿Qué novela distópica de Aldous Huxley presenta un mundo en el que la sociedad es controlada por el consumo de una droga llamada Soma?", listOf(
            Option("a) '1984'", false),
            Option("b) 'Un Mundo Feliz'", true),
            Option("c) 'Fahrenheit 451'", false),
            Option("d) 'Nosotros'", false)
        )),
        Question("¿Cuál es la novela ganadora del Premio Pulitzer en 1982 escrita por Gabriel García Márquez?", listOf(
            Option("a) 'Cien años de soledad'", false),
            Option("b) 'Crónica de una muerte anunciada'", false),
            Option("c) 'El amor en los tiempos del cólera'", true),
            Option("d) 'La hojarasca'", false)
        )),
        Question("¿Qué autor ruso escribió 'Guerra y paz'?", listOf(
            Option("a) Fyodor Dostoevsky", false),
            Option("b) Anton Chekhov", false),
            Option("c) Leo Tolstoy", true),
            Option("d) Ivan Turgenev", false)
        )),
        Question("¿Cuál es la obra de Miguel de Cervantes que narra las aventuras de Don Quijote y Sancho Panza?", listOf(
            Option("a) 'La Celestina'", false),
            Option("b) 'La vida es sueño'", false),
            Option("c) 'Don Quijote de la Mancha'", true),
            Option("d) 'Fuenteovejuna'", false)
        )),
        Question("¿Qué novela de Margaret Atwood presenta un futuro distópico en el que la fertilidad es escasa?", listOf(
            Option("a) 'Alias Grace'", false),
            Option("b) 'La historia de Agua'?", false),
            Option("c) 'El cuento de la criada'", true),
            Option("d) 'Gilead'", false)
        )),
        Question("¿Quién escribió 'Crónica de una muerte anunciada'?", listOf(
            Option("a) Mario Vargas Llosa", false),
            Option("b) Julio Cortázar", false),
            Option("c) Gabriel García Márquez", true),
            Option("d) Toni Morrison", false)
        )),
        Question("¿Quién es el autor de 'En el camino'?", listOf(
            Option("a) Jack Kerouac", true),
            Option("b) Allen Ginsberg", false),
            Option("c) William S. Burroughs", false),
            Option("d) Neal Cassady", false)
        )),
        Question("¿Cuál es el título de la novela de Salman Rushdie que provocó una controversia internacional debido a su representación de figuras religiosas?", listOf(
            Option("a) 'Los hijos de la medianoche'", true),
            Option("b) 'Shalimar el payaso'", false),
            Option("c) 'El suelo bajo sus pies'", false),
            Option("d) 'Furia'", false)
        )),
        Question("¿Quién escribió 'La broma infinita', una novela posmoderna conocida por su longitud y complejidad?", listOf(
            Option("a) David Foster Wallace", true),
            Option("b) Thomas Pynchon", false),
            Option("c) Don DeLillo", false),
            Option("d) Jonathan Franzen", false)
        )),
        Question("¿Cuál es el título de la novela de Aldous Huxley que imagina un futuro distópico en el que la sociedad está dominada por el uso de drogas y la tecnología?", listOf(
            Option("a) 'Un Mundo Feliz'", true),
            Option("b) 'El fin de la eternidad'", false),
            Option("c) 'Islas a la deriva'", false),
            Option("d) 'La carretera'", false)
        )),
        Question("¿Quién es el autor de 'La carretera', novela que narra el viaje de un padre y su hijo en un mundo devastado?", listOf(
            Option("a) Cormac McCarthy", true),
            Option("b) Stephen King", false),
            Option("c) Margaret Atwood", false),
            Option("d) Kazuo Ishiguro", false)
        )),
        Question("¿Cuál es el título de la novela de Leo Tolstoy que narra la historia de la alta sociedad rusa durante la invasión napoleónica?", listOf(
            Option("a) 'La Guerra y la Paz'", false),
            Option("b) 'Anna Karenina'", false),
            Option("c) 'Guerra y paz'", true),
            Option("d) 'Resurrección'", false)
        )),
        Question("¿Quién es el autor de la novela 'Bajo el volcán'?", listOf(
            Option("a) Ernest Hemingway", false),
            Option("b) F. Scott Fitzgerald", false),
            Option("c) Malcolm Lowry", true),
            Option("d) John Steinbeck", false)
        )),
        Question("¿Cuál es el título de la novela de Thomas Pynchon que se desarrolla en la década de 1960 y trata sobre paranoia, conspiraciones y la Guerra Fría?", listOf(
            Option("a) 'Inherent Vice'", false),
            Option("b) 'V.'", false),
            Option("c) 'El arco iris de la gravedad'", true),
            Option("d) 'Mason & Dixon'", false)
        )),
        Question("¿Quién escribió 'Cumbres Borrascosas'?", listOf(
            Option("a) Jane Austen", false),
            Option("b) Charlotte Brontë", false),
            Option("c) Emily Brontë", true),
            Option("d) Anne Brontë", false)
        )),
        Question("¿Cuál es el título de la novela de Herman Melville que narra la obsesión del capitán Ahab por una ballena?", listOf(
            Option("a) 'La isla del tesoro'", false),
            Option("b) '20000 leguas de viaje submarino'", false),
            Option("c) 'Moby-Dick'", true),
            Option("d) 'Robinson Crusoe'", false)
        )),
        Question("¿En que libro se basa esta escena?", listOf(
            Option("a) El Hobbit", false),
            Option("b) El Señor de los Anillos", false),
            Option("c) Harry Potter", true)
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
            .padding(20.dp)
            .offset(y = (90).dp),
        verticalArrangement = Arrangement.Top,

        ) {
        if (contBooks < 10) {
            val question = questions[randomBooks]
            Box(){
                Text(text = question.text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
            if(randomBooks == questions.size-1)
            {
                VideoPlayer(videoUri = videoUriBook)
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
                        .clickable { selectedOptionBooks = option }
                        .offset(y = (20).dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "",
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { selectedOptionBooks = option }
                        .offset(y = (1).dp)
                        .align(Alignment.CenterHorizontally)
                )

                RadioButton(
                    selected = option == selectedOptionBooks,
                    onClick = { selectedOptionBooks = option },
                    modifier = Modifier.fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
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
                        randomBooks= Random.nextInt(0,37)
                        while(visit.contains(randomBooks)){
                            randomBooks= Random.nextInt(0,37)
                        }

                        reset = 1
                        contBooks+=1
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


