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
var random=41
var cont=0
val visit= mutableListOf<Int>()
val videoUri = Uri.parse("android.resource://com.example.questiongame/raw/video1")

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
        Question("¿Cuál es una película de terror sobre un asesino llamado Michael Myers?", listOf(
            Option("a) A Nightmare on Elm Street", false),
            Option("b) Friday the 13th", false),
            Option("c) Halloween", true),
            Option("d) The Exorcist", false)
        )),
        Question("En la película 'The Shining', ¿quién interpreta al escritor Jack Torrance?", listOf(
            Option("a) Jack Nicholson", true),
            Option("b) Al Pacino", false),
            Option("c) Marlon Brando", false),
            Option("d) Robert De Niro", false)
        )),
        Question("En la película 'E.T. the Extra-Terrestrial', ¿quién es el director de la película?", listOf(
            Option("a) George Lucas", false),
            Option("b) James Cameron", false),
            Option("c) Steven Spielberg", true),
            Option("d) Christopher Nolan", false)
        )),
        Question("En la película 'The Dark Knight', ¿cuál es el nombre del personaje interpretado por Heath Ledger?", listOf(
            Option("a) Two-Face", false),
            Option("b) The Riddler", false),
            Option("c) The Joker", true),
            Option("d) Scarecrow", false)
        )),
        Question("En la película 'Forrest Gump', ¿qué actor interpreta a Forrest Gump?", listOf(
            Option("a) Tom Hanks", true),
            Option("b) Robert De Niro", false),
            Option("c) Brad Pitt", false),
            Option("d) Johnny Depp", false)
        )),
        Question("En la película 'No Country for Old Men', ¿cuál es el nombre del asesino interpretado por Javier Bardem?", listOf(
            Option("a) Anton Chigurh", true),
            Option("b) Llewelyn Moss", false),
            Option("c) Ed Tom Bell", false),
            Option("d) Carson Wells", false)
        )),
        Question("En la película 'Una mente maravillosa', ¿quién interpreta al matemático John Nash, quien sufre de esquizofrenia?", listOf(
            Option("a) Russell Crowe", true),
            Option("b) Sean Connery", false),
            Option("c) Anthony Hopkins", false),
            Option("d) Tom Hanks", false)
        )),
        Question("En la película 'The Usual Suspects', ¿quién es el misterioso narrador de la historia, también conocido como Keyser Söze?", listOf(
            Option("a) Verbal Kint", true),
            Option("b) Dean Keaton", false),
            Option("c) Todd Hockney", false),
            Option("d) Michael McManus", false)
        )),
        Question("En la película 'La Naranja Mecanica', el personaje principal es un amante de la música clásica. ¿Quién es su compositor favorito?", listOf(
            Option("a) Beethoven", false),
            Option("b) Mozart", true),
            Option("c) Bach", false),
            Option("d) Chopin", false)
        )),
        Question("En la película 'Memento' ¿Qué objeto usa el protagonista para recordar información importante?", listOf(
            Option("a) Un diario", false),
            Option("b) Tatuajes en su cuerpo", true),
            Option("c) Un reloj de pulsera especial", false),
            Option("d) Fotografías", false)
        )),
        Question("En la película 'Apocalypse Now', ¿cuál es el nombre del coronel interpretado por Marlon Brando?", listOf(
            Option("a) Coronel Johnson", false),
            Option("b) Coronel Smith", false),
            Option("c) Coronel Kurtz", true),
            Option("d) Coronel Parker", false)
        )),
        Question("En la película 'Citizen Kane', ¿cuál es el significado de la palabra 'Rosebud'?", listOf(
            Option("a) El nombre de la amante de Charles Foster Kane", false),
            Option("b) El nombre de la madre de Charles Foster Kane", false),
            Option("c) El trineo de la infancia de Charles Foster Kane", true),
            Option("d) El apodo de Charles Foster Kane en la escuela", false)
        )),
        Question("En la película 'Schindler's List', ¿cuál es el nombre del empresario alemán que salva a judíos durante el Holocausto?", listOf(
            Option("a) Adolf Hitler", false),
            Option("b) Heinrich Himmler", false),
            Option("c) Oskar Schindler", true),
            Option("d) Joseph Goebbels", false)
        )),
        Question("En la película 'The Godfather Part II', ¿qué actor interpreta al joven Vito Corleone?", listOf(
            Option("a) Robert De Niro", true),
            Option("b) Al Pacino", false),
            Option("c) Marlon Brando", false),
            Option("d) Joe Pesci", false)
        )),
        Question("En la película 'La La Land', ¿qué instrumento musical toca el personaje de Ryan Gosling?", listOf(
            Option("a) Piano", true),
            Option("b) Violín", false),
            Option("c) Guitarra", false),
            Option("d) Trompeta", false)
        )),
        Question("En la película 'A Streetcar Named Desire', ¿quién interpreta el icónico papel de Blanche DuBois?", listOf(
            Option("a) Meryl Streep", false),
            Option("b) Bette Davis", false),
            Option("c) Vivien Leigh", true),
            Option("d) Katharine Hepburn", false)
        )),
        Question("En la película 'The Truman Show', ¿quién interpreta al personaje principal, Truman Burbank?", listOf(
            Option("a) Jim Carrey", true),
            Option("b) Tom Hanks", false),
            Option("c) Will Ferrell", false),
            Option("d) Robin Williams", false)
        )),
        Question("En la película 'El Gran Hotel Budapest', ¿quién interpreta al conserje Gustave H.?", listOf(
            Option("a) Ralph Fiennes", true),
            Option("b) Jude Law", false),
            Option("c) Bill Murray", false),
            Option("d) Daniel Day-Lewis", false)
        )),
        Question("En la película 'El laberinto del fauno', ¿quién es el director mexicano conocido por su estilo oscuro y fantástico?", listOf(
            Option("a) Alfonso Cuarón", false),
            Option("b) Guillermo del Toro", true),
            Option("c) Alejandro González Iñárritu", false),
            Option("d) Pedro Almodóvar", false)
        )),
        Question("En la película 'El renacido', ¿quién interpreta al trampero Hugh Glass?", listOf(
            Option("a) Tom Hardy", false),
            Option("b) Leonardo DiCaprio", true),
            Option("c) Christian Bale", false),
            Option("d) Matthew McConaughey", false)
        )),
        Question("En la película 'Birdman', ¿cuál es el nombre del personaje que intenta revitalizar su carrera como actor en Broadway?", listOf(
            Option("a) Riggan Thomson", true),
            Option("b) Jack Sparrow", false),
            Option("c) Truman Burbank", false),
            Option("d) Ron Burgundy", false)
        )),
        Question("En la película 'La forma del agua', ¿quién interpreta a la limpiadora que se enamora de una criatura acuática?", listOf(
            Option("a) Sally Hawkins", true),
            Option("b) Cate Blanchett", false),
            Option("c) Frances McDormand", false),
            Option("d) Michelle Williams", false)
        )),
        Question("En la película 'Drive', ¿quién interpreta al protagonista, un conductor de autos y especialista en cine que se involucra en un mundo criminal?", listOf(
            Option("a) Ryan Gosling", true),
            Option("b) Jason Statham", false),
            Option("c) Keanu Reeves", false),
            Option("d) Tom Hardy", false)
        )),
        Question("En la película 'Lost in Translation', ¿quién interpreta a una joven que forma un vínculo especial con un actor en un hotel de Tokio?", listOf(
            Option("a) Scarlett Johansson", true),
            Option("b) Keira Knightley", false),
            Option("c) Natalie Portman", false),
            Option("d) Emma Stone", false)
        )),
        Question("En la película 'Requiem por un sueño', ¿quién interpreta el papel de la madre adicta Sara Goldfarb?", listOf(
            Option("a) Ellen Burstyn", true),
            Option("b) Meryl Streep", false),
            Option("c) Glenn Close", false),
            Option("d) Cate Blanchett", false)
        )),
        Question("En la película 'Oldboy', ¿quién es el director surcoreano conocido por su estilo visual impactante y narrativas retorcidas?", listOf(
            Option("a) Park Chan-wook", true),
            Option("b) Bong Joon-ho", false),
            Option("c) Kim Ki-duk", false),
            Option("d) Hong Sang-soo", false)
        )),
        Question("En la película 'The Big Lebowski', ¿cuál es el apodo del personaje principal, interpretado por Jeff Bridges?", listOf(
            Option("a) The Dude", true),
            Option("b) The Boss", false),
            Option("c) The Captain", false),
            Option("d) The Professor", false)
        )),
        Question("En la película '12 Monkeys', ¿quién interpreta al viajero en el tiempo que intenta prevenir una plaga mundial?", listOf(
            Option("a) Bruce Willis", true),
            Option("b) Brad Pitt", false),
            Option("c) Edward Norton", false),
            Option("d) Morgan Freeman", false)
        )),
        Question("En la película 'Children of Men', ¿cuál es el nombre del director de fotografía conocido por su uso de largos planos secuencia?", listOf(
            Option("a) Emmanuel Lubezki", true),
            Option("b) Roger Deakins", false),
            Option("c) Janusz Kamiński", false),
            Option("d) Wally Pfister", false)
        )),

                Question("En la película 'Whiplash', ¿quién interpreta al estricto y perfeccionista profesor de música Terence Fletcher?", listOf(
            Option("a) J.K. Simmons", true),
            Option("b) Miles Teller", false),
            Option("c) Ethan Hawke", false),
            Option("d) Paul Reiser", false)
        )),
        Question("¿A qué película pertenece esta escena?", listOf(
            Option("a) The Orange Clockwork", false),
            Option("b) Silence of the Lambs", false),
            Option("c) The Shining", true)
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
            if(random == questions.size-1)
            {
                VideoPlayer(videoUri = videoUri)
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

                        }
                        visit.add(random)
                        random= Random.nextInt(0,41)
                        while(visit.contains(random)){
                            random= Random.nextInt(0,41)
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
