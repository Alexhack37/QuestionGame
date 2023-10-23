package com.example.questiongame.ui.theme

import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.questiongame.TimeFormatExt.timeFormat
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class CountDownTimerViewModel : ViewModel(){

    private var countDownTimer: CountDownTimer? = null

    private val userInputSecond = TimeUnit.SECONDS.toMillis(10)

    val initialTotalTimeInMillis = userInputSecond
    var timeLeft = mutableStateOf(initialTotalTimeInMillis)
    val countDownInterval = 1000L  //Valor mínimo 1 segundo

    val timerText = mutableStateOf(timeLeft.value.timeFormat())

    val isPlaying = mutableStateOf(false)


    fun startCountDownTimer (navController: NavController) = viewModelScope.launch {
        isPlaying.value = true
        countDownTimer = object: CountDownTimer(timeLeft.value, countDownInterval){
            override fun onTick(currentTimeLeft: Long) {
                timerText.value = currentTimeLeft.timeFormat()
                timeLeft.value = currentTimeLeft
            }
            override fun onFinish(){
                timerText.value = initialTotalTimeInMillis.timeFormat()
                isPlaying.value = false
                navController.navigate(route = com.example.questiongame.Screen.Home.route)
            }
        }.start()
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



