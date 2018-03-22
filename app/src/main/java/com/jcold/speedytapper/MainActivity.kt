package com.jcold.speedytapper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 0
    var blankString = ""
    var startTimer: CountDownTimer? = null
    var stopTimer: CountDownTimer? = null
    var remaining_time: TextView? = null
    var countdown_text: TextView? = null
    var timerIsStarted = false
    var highscoreText: TextView? = null
    var highScore = 0
    var currentscoreText: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        gameFiveSeconds()
    }

    private fun bindViews() {
        remaining_time = findViewById(R.id.countdown_timer)
        countdown_text = findViewById(R.id.countdown_timer)
        highscoreText = findViewById(R.id.high_score)
        currentscoreText = findViewById(R.id.current_score)


    }

    private fun highScoreSetter(){
        if (highScore < counter){
           highScore = counter
                   highscoreText?.setText("High Score: "+blankString+counter)
        }
    }

    private fun currentScoreSetter(){
        currentscoreText?.setText("Score: "+counter)
    }

    private fun gameTimerStart(){
        startTimer = object : CountDownTimer(5000, 1) {
            override fun onTick(millisUntilFinished: Long) {
                timerIsStarted = true
                var seconds = (millisUntilFinished / 1000) %60
                var milli = (millisUntilFinished % 1000)
                countdown_text?.setText("Seconds: "+ String.format("%d.%02d", seconds, milli))
            }

            override fun onFinish() {
                timerIsStarted = false
                countdown_text?.setText("Seconds: 5")
                highScoreSetter()
                currentScoreSetter()
                counter =0
                number_increasing.setText(blankString+counter)
            }
        }.start()
    }

    private fun gameFiveSeconds() {

        button_reset_timer.setOnClickListener{

            highScoreSetter()
            currentScoreSetter()
            counter =0
            number_increasing.setText(blankString+counter)
            startTimer?.cancel()
            countdown_text?.setText("Seconds: 5")
            timerIsStarted = false
        }

        myButton.setOnClickListener{
            if (!timerIsStarted){
                gameTimerStart()
            }
            counter += 1
            number_increasing.setText(blankString+counter)
        }
    }
}
