

package com.example.questiongame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.questiongame.ui.theme.QuestionGameTheme

// como cambiar de escenas https://youtu.be/glyqjzkc4fk


// como meter screen
// 1 vete a screen.kt
class MainActivity : ComponentActivity() {

    //VideoView =


    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuestionGameTheme {

                navController = rememberNavController()

                SetUpNavGraph(navController = navController)

            }
        }
    }
}


