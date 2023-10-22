package com.example.questiongame.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    /*private var countDownTimer: CountDownTimer? = null

    private val userInputSecond = TimeUnit.SECONDS.toMillis(10)

    val initialTotalTimeInMillis = userInputSecond
    var timeLeft = mutableStateOf(initialTotalTimeInMillis)
    val countDownInterval = 1000L  //Valor mínimo 1 segundo

    val timerText = mutableStateOf(timeLeft.value.timeFormat())

    val isPlaying = mutableStateOf(false)

    init {
        viewModelScope.launch() {
            // Coroutine that will be canceled when the ViewModel is cleared.
        }
    }

    fun startCountDownTimer() = viewModelScope.launch {
        isPlaying.value = true
        countDownTimer = object: CountDownTimer(timeLeft.value, countDownInterval){
            override fun onTick(currentTimeLeft: Long) {
                timerText.value = currentTimeLeft.timeFormat()
                timeLeft.value = currentTimeLeft
            }

            override fun onFinish(){
                timerText.value = initialTotalTimeInMillis.timeFormat()
                isPlaying.value = false
                //AQUÍ CAMBIAR DE EESCENA
            }
        }
    }.start()

    fun stopCountDownTimer() = viewModelScope.launch {
        isPlaying.value = false
        countDownTimer?.cancel()
    }

    fun resetCountDownTimer() = viewModelScope.launch {
        isPlaying.value = false
        countDownTimer?.cancel()
        timerText.value = initialTotalTimeInMillis.timeFormat()
        timeLeft.value = initialTotalTimeInMillis
    }*/
}