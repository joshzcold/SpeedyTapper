package com.jcold.speedytapper

import android.content.Context

class LeaderBoards(context: Context){
    val PREFERENCE_NAME = "LeaderBoards_Preference"
    val PREFERENCE_FIVE_HIGH_SCORE = "preference_five_high_score"

    val preference = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun getFiveSecondHighScore(): Int{
        return preference.getInt(PREFERENCE_FIVE_HIGH_SCORE, 0)
    }

    fun setFiveSecondHighScore(high_score:Int){
        val editor = preference.edit()
        editor.putInt(PREFERENCE_FIVE_HIGH_SCORE,high_score)
        editor.apply()
    }
}