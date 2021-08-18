package com.example.triviarecyclerview_august9.ui.trivia.viewmodel

import androidx.lifecycle.*
import com.example.triviarecyclerview_august9.model.models.Answer
import com.example.triviarecyclerview_august9.model.models.Question
import com.example.triviarecyclerview_august9.model.repository.TriviaRepoImpl

class TriviaViewModel : ViewModel() {

    val score: LiveData<Int> = TriviaRepoImpl.score

    val questions: LiveData<List<Question>> = TriviaRepoImpl.questions

    fun onAnswerSelected(answer: Answer) {
        if (answer.isCorrect) {
            TriviaRepoImpl.addPoint()
        }
    }

    fun deleteQuestion(question: Question) {
        TriviaRepoImpl.deleteQuestion(question)
    }

}