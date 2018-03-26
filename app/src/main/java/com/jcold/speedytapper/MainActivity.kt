package com.jcold.speedytapper

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var menuFiveSecondButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        menuFiveSecondButton?.setOnClickListener { fiveSecondGame() }
    }

    private fun fiveSecondGame() {
        val intent = Intent(this, FiveSecondGameActivity::class.java)
        startActivity(intent)
    }

    private fun bindViews() {
        menuFiveSecondButton = findViewById(R.id.menu_five_seconds)
    }

}
