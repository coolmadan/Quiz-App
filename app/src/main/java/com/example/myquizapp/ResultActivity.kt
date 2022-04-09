package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvName :TextView =findViewById(R.id.tv_username)
        val tvScore :TextView=findViewById(R.id.tv_score)
        val btnFinish : Button =findViewById(R.id.btn_finish)
        tvName.text=intent.getStringExtra(  Constants.USER_NAME)
        val totalQuestion =intent.getIntExtra(Constants.TOTAL_QUESTION,0)//if the ide doesnot get any value in  total question so the default value would be 0
        val corrrectAnswers =intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        tvScore.text="Your score is $corrrectAnswers out of $totalQuestion"
        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}