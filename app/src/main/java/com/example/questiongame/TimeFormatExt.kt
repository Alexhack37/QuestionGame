package com.example.questiongame
import java.util.concurrent.TimeUnit


object TimeFormatExt {
    private const val FORMAT = "%02d"

    fun Long.timeFormat(): String = String.format(
        FORMAT,
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )
}