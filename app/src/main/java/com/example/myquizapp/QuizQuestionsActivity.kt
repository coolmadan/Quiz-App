package com.example.myquizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.w3c.dom.Text
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView
import java.security.cert.PKIXRevocationChecker

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener //QuizQuestionActivity inherits from appcompatactivity but its also implementing the viewonlclicklistener
{
    private var mcurrentposition: Int = 1//the variable is declared outside nay method or function so that it can be used globally
    private var mQuestionsList: ArrayList<Question>? = null//mQuestionList is an array list of questions and we need to make it nullable because we cannot assign it outside of any method or function we need yto assing it inside of the oncreate method
    private var mSelectedOptionPosition: Int = 0//this mSelectedOptionPosition will tell us which option is selected and by default we are setting its value as 0and on clicking we are going to override the value of the mselectedoptionposition
    private var mUserName :String?=null
    private var mCorrectAnswers :Int=0
    //we need to know the selected option because our option were four and the correct option among them was one so we need to compare whether the selected option is correct or not
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var btnimage: ImageView? = null
    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var btnSubmit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName=intent.getStringExtra(Constants.USER_NAME)//SO this is how I can use the intent which got me to this activity and I get its details at the position of the username which is present in Constants file
        //In main activity i used the put extra with a string that i sent over so i need to retrieve it as a string by using the getstringextra
        progressBar = findViewById(R.id.tv_progressbar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        optionOne = findViewById(R.id.tv_option_one)
        optionTwo = findViewById(R.id.tv_option_two)
        optionThree = findViewById(R.id.tv_option_three)
        optionFour = findViewById(R.id.tv_option_four)
        btnimage = findViewById(R.id.iv_image)
        btnSubmit = findViewById(R.id.btn_submit)
        optionOne?.setOnClickListener(this)//i am just saying that this(i.e. quizquestionsactivity should be the onclicklistener(which we can see above that it is an onclicklistener) and then we are executing the onclick method which is an override method
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()//we need to get Questions from the question list

        setQuestion()

    }


    private fun setQuestion() {
        defaultOptionsView()


        val question: Question =
            mQuestionsList!![mcurrentposition - 1]//mQuestionList was nullable so we need to force unwrap it hear so we will use two exclamation because I am sure the questionlist is not going to be empty at this point
        btnimage?.setImageResource(question.Image)
        progressBar?.progress = mcurrentposition
        tvProgress?.text = "$mcurrentposition /${progressBar?.max}"
        tvQuestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour
        if (mcurrentposition == mQuestionsList!!.size)//Here what we are doing is we are checking if the mycurrentposition is at the end or equal to the size of the questionlist so that it would change the text of the button submit to finish
        {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView()//this function is basically going to reset the colour of all the options
    {
        val options =
            ArrayList<TextView>()//this will provide me the options(every option is a textview so ig it gives us options through that
        optionOne?.let {
            options.add(
                0,
                it
            )//let takes the object it is invoked upon as the parameter and returns the result of the lambda expression.
            //Kotlin let is a scoping function wherein the variables declared inside the expression cannot be used outside.
        }
        optionTwo?.let {
            options.add(1, it)
        }
        optionThree?.let {
            options.add(2, it)
        }
        optionFour?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7C99AC"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )//here r stands for resources and drawable is the folder and default option border bg is the file name which is implemented on the border of each option
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int)//we need to know which textview we need to change and then which option it was that's why we are using parameters in this method
    {
        defaultOptionsView() //Here we are calling the default option view which reset the options to the normal state i.e if we have lcicked on any option and then we change the option to reset the earlier option this function is called
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)//here we are changing our font of the option which is selected
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg

        )
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> {
                optionOne?.let {
                  selectedOptionView(it, 1)
                }
            }
            //here it is option one which we are passing because the option one itself is the textview and passing the value of the selected option as 1
            R.id.tv_option_two -> {
                optionTwo?.let {
                 selectedOptionView(it, 2)
                }
            }
            R.id.tv_option_three -> {
                optionThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option_four -> {
                optionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit->
            {
                if(mSelectedOptionPosition==0) {
                    mcurrentposition++

                    when {
                        mcurrentposition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else->{
                            //i am going to send the program to the another activity by creating a new intent
                            val intent =Intent(this,ResultActivity::class.java)//from this context(activity) to result activity
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            i ntent.putExtra(Constants.TOTAL_QUESTION,mQuestionsList?.size)
                            startActivity(intent)
                            finish()//this finish helps your user to exit the app if it is not used it would go back again and again to the last page
                        }
                    }
                }else
                {
                 val question=mQuestionsList?.get(mcurrentposition-1)
                 if(question!!.correctAnswer!=mSelectedOptionPosition)
                 {
                     answerview(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                 }else{
                     mCorrectAnswers++
                 }
                    answerview(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if(mcurrentposition==mQuestionsList!!.size)
                    {
                        btnSubmit?.text="FINISH"
                    }else
                    {
                        btnSubmit?.text="NEXT"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }

    }
    private fun answerview(answer: Int,drawableView: Int)
    {
        when(answer)
        {
            1->{
                optionOne?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                optionTwo?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                optionThree?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                optionFour?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }


}



