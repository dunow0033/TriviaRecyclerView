package com.example.triviarecyclerview_august9.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.triviarecyclerview_august9.model.models.Answer
import com.example.triviarecyclerview_august9.model.models.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object TriviaRepoImpl {

    private val question1 = Question(
        "What does an onion have?",
        Answer("layers", true),
        Answer("Breett"),
        Answer("Peel"),
        Answer("Pills")
    )
    private val question2 = Question(
        "What does an onion have?",
        Answer("layers", true),
        Answer("Breett"),
        Answer("Peel"),
        Answer("Pills")
    )
    private val question3 = Question(
        "What does an onion have?",
        Answer("layers", true),
        Answer("Breett"),
        Answer("Peel"),
        Answer("Pills")
    )
    private val question4 = Question(
        "What does an onion have?",
        Answer("layers", true),
        Answer("Breett"),
        Answer("Peel"),
        Answer("Pills")
    )

    private val questionList = mutableListOf(question1, question2, question3, question4)
    private var currentScore = 0

    val questions: MutableLiveData<List<Question>> = MutableLiveData(questionList)

    fun deleteQuestion(question: Question) {
        questionList.remove(question)
        questions.value = questionList
    }

    val score: MutableLiveData<Int> = MutableLiveData(currentScore)

    fun addPoint() {
        currentScore++
        score.value = currentScore
    }
}