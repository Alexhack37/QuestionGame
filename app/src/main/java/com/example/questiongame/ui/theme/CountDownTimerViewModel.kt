package com.example.questiongame.ui.theme

import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.questiongame.TimeFormatExt.timeFormat
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

var restTime:Long=0
class CountDownTimerViewModel : ViewModel(){

    private var countDownTimer: CountDownTimer? = null

    private val userInputSecond = TimeUnit.SECONDS.toMillis(59)

    val initialTotalTimeInMillis = userInputSecond
    var timeLeft = mutableStateOf(initialTotalTimeInMillis)
    val countDownInterval = 1000L  //Valor mínimo 1 segundo

    val timerText = mutableStateOf(timeLeft.value.timeFormat())

    val isPlaying = mutableStateOf(false)
    var time = 0


    fun startCountDownTimer (navController: NavController) = viewModelScope.launch {
        isPlaying.value = true
        countDownTimer = object: CountDownTimer(timeLeft.value, countDownInterval){
            override fun onTick(currentTimeLeft: Long) {
                timerText.value = currentTimeLeft.timeFormat()
                timeLeft.value = currentTimeLeft
                restTime=timeLeft.value
            }
            override fun onFinish() {
                //timerText.value = initialTotalTimeInMillis.timeFormat()
                timerText.value = "SE ACABÓ"
                stopCountDownTimer()

                //navController.navigate(route = com.example.questiongame.Screen.PuntuationScreen.route)
                //time += 1
            }
        }.start()
        /*if(time>= 1){
            navController.navigate(route = com.example.questiongame.Screen.PuntuationScreen.route)
            time =0
        }*/
    }

    fun stopCountDownTimer() = viewModelScope.launch {
        isPlaying.value = false
        countDownTimer?.cancel()
    }

    fun resetCountDownTimer() = viewModelScope.launch {
        isPlaying.value = false
        countDownTimer?.cancel()
        timerText.value = initialTotalTimeInMillis.timeFormat()
        timeLeft.value = initialTotalTimeInMillis
    }
}