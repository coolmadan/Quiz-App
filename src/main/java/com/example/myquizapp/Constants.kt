package com.example.myquizapp

object Constants {
    const val USER_NAME : String ="user_name"
    const val TOTAL_QUESTION:String="total_question"
    const val CORRECT_ANSWERS:String="correct_answers"
    //these are just the keys under which we are storing the values or details so that we can retrieve them when we are moving data from one activity to other
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val ques1 =Question(
            1,
            "Former Australian Mark Taylor has had several nicknames over his playing career.Which of the following was not one of them ?",
            R.drawable.cricket,
            "Tubby",
            "Stodge",
            "Helium Bat",
            "Stumpy",
            3
        )
        questionsList.add(ques1)
        val ques2= Question(
            2,
            "Who invented the ballpoint pen",
            R.drawable.ballpointpen,
            "Biro Brothers",
            "Waterman Brothers",
            "Bicc Brothers",
            "Write Brothers",
            1
        )
        questionsList.add(ques2)
        val ques3=Question(
            3,
            "Which scientist discovered the radioactive element radium",
            R.drawable.radium,
            "Isaac Newton",
            "Albert Einstein",
            "Benjamin Franklin",
            "Marie Curie",
            4
        )
        questionsList.add(ques3)
        val ques4=Question(
            4,
            "Which among the following had called Rabindranath Tagore as THE GREAT SENTINEL",
            R.drawable.rabindranathtagore,
            "Abdul Kalam Azad",
            "Mahatma Gandhi",
            "Dr. Rajendra Prasad",
            "Subhash Chandra Bose",
            2
        )
        questionsList.add(ques4)
        val ques5=Question(
            5,
            "Which city is considered as the financial capital of the Germany?",
            R.drawable.germanymap,
            "Frankfurt",
            "Hamburg",
            "Stuttgart",
            "None of the above",
            3
            )
        questionsList.add(ques5)
        val ques6=Question(
            6,
            "What does the word 'Zeitgeist' mean?",
            R.drawable.zeitgiest,
            "An autobiographical novel",
            "BLess you!",
            "Pleasure in watching other people suffer",
            "Spirit of the times",
            4
        )
        questionsList.add(ques6)
        val ques7=Question(
            7,
            "Grand Central Terminal,Park Avenue,New York is the world,s",
            R.drawable.grandcentralterminal,
            "highest railway station",
            "longest railway station",
            "largest railway station",
            "None of the above",
            3
        )
        questionsList.add(ques7)
        val ques8=Question(
            8,
            "Entomology is the science that studies",
            R.drawable.science,
            "The origin and history of technical and scientific terms",
            "Behavior of human beings",
            "Insects",
            "The formation of rocks",
            3
        )
        questionsList.add(ques8)
        val ques9=Question(
            9,
            "Which of these country's flags looks most similar to Germany's?",
            R.drawable.belgium,
            "Australia",
            "Belgium",
            "South Africa",
            "Norway",
            2
        )
        questionsList.add(ques9)
        val ques10=Question(
            10,
            "Who is the father of Geometry?",
            R.drawable.geometry,
            "Aristotle",
            "Euclid",
            "Pyhtogoras",
            "Kepler",
            2
        )
        questionsList.add(ques10)
        val ques11=Question(
            11,
            "Professor Amartya Sen is famous in which of the fields?",
            R.drawable.amartyasen,
            "Biochemistry",
            "Electronics",
            "Economics",
            "Geology",
            3
        )
        questionsList.add(ques11)
        val ques12=Question(
            12,
            "Which of the following was Satyajit Ray associated with?",
            R.drawable.satyajitray,
            "Classical music",
            "Commercial art",
            "Film Direction",
            "Classical dance",
            3
        )
        questionsList.add(ques12)
        return questionsList
    }
}