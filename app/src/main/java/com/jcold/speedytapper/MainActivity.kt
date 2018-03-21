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
    var scoreText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        gameFiveSeconds()
    }

    private fun bindViews() {
        remaining_time = findViewById(R.id.countdown_timer)
        countdown_text = findViewById(R.id.countdown_timer)
        scoreText = findViewById(R.id.ending_score)


    }

    private fun gameTimerStart(){
        startTimer = object : CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerIsStarted = true
                countdown_text?.setText("Seconds: "+ millisUntilFinished / 1000)
            }

            override fun onFinish() {
                timerIsStarted = false
                countdown_text?.setText("Seconds: 0")
                scoreText?.setText("Score: "+blankString+counter)
                counter =0
                number_increasing.setText(blankString+counter)
            }
        }.start()
    }

    private fun gameFiveSeconds() {

        button_reset_timer.setOnClickListener{

            scoreText?.setText("Score: "+blankString+counter)
            counter =0
            number_increasing.setText(blankString+counter)
            startTimer?.cancel()
            countdown_text?.setText("Seconds: 0")
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
