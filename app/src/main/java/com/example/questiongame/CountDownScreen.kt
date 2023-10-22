package com.example.questiongame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.questiongame.ui.theme.CountDownTimerViewModel



//FUNCION QUE DICE SI EXISTE O NO O ES CORRECTA O NO
/*
@Composable
fun CountDownScreen(

    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: CountDownTimerViewModel = viewModel()) {
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
}
*/
@Composable
fun EndQuestion(showBox: Boolean, correct: Int) {
    if (showBox) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Button(onClick = {}, Modifier.padding(top = 125.dp)) {
                Text(text = "Next", fontSize = 28.sp)
            }
            if (correct == 0) {
                Text(text = "CORRECT!",
                    fontSize = 50.sp,
                    )
            }
            else if (correct == 1){
                Text(text = "INCORRECT!",
                    fontSize = 50.sp,
                )
            }
            else if (correct == 2){
                Text(text = "TIME'S OUT!",
                    fontSize = 50.sp,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CountDownScreenPreview() {
    /*CountDownScreen(
        navController = rememberNavController()
    )*/
    EndQuestion(showBox = true, correct = 2)
}