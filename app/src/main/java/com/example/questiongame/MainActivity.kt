package com.example.questiongame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.questiongame.ui.theme.QuestionGameTheme





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuestionGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    TituloJuego("Askers!")
                }
            }
        }
    }
}


@Composable
fun TituloJuego(name: String, modifier: Modifier = Modifier) {
    Text(
        text = " $name",
        modifier = modifier
    )
    /*
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            shape = MaterialTheme.shapes.medium
            onClick =
        ) {
            Text(
                //text = stringResource(id = "Jugar"),
                text = "Jugar",
                style = MaterialTheme.typography.titleSmall
            )
        }
    }*/
}
@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    QuestionGameTheme {
        TituloJuego("Askers!")
    }
}