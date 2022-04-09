package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart :Button=findViewById(R.id.btn_start)
        val etName : EditText=findViewById(R.id.et_name)
        btnStart.setOnClickListener()
        {
            if (etName.text.isEmpty()) {
                Toast.makeText(this,
                    "Please Enter your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etName.text.toString())//an intent can have extra information that you can send from one activity to another
                //etName is the name which you got from input at the first page so we are basically using that variable only to display the name
                //also we are not sending this intent to result activity but rather to the quizquestionsactivity
                startActivity(intent)
                finish()
            }
        }
    }
}