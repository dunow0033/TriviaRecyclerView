package com.example.triviarecyclerview_august9.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triviarecyclerview_august9.databinding.ItemTriviaBinding
import com.example.triviarecyclerview_august9.model.models.Answer
import com.example.triviarecyclerview_august9.model.models.Question

class TriviaAdapter(
    private val listener: (answer: Answer, question: Question) -> Unit,
) : RecyclerView.Adapter<TriviaAdapter.TriviaViewHolder>() {

    private var listOfQuestions = emptyList<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TriviaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTriviaBinding.inflate(layoutInflater, parent, false)
        return TriviaViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: TriviaViewHolder, position: Int) {
        holder.bind(listOfQuestions[position])
    }

    override fun getItemCount(): Int {
        return listOfQuestions.size
    }

    fun setItems(questions: List<Question>) {
        listOfQuestions = questions
        notifyDataSetChanged()
    }

    class TriviaViewHolder(
        private val binding: ItemTriviaBinding,
        private val listener: (answer: Answer, question: Question) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: Question) {
            with(binding) {
                questionTv.text = question.question
                answer1.apply {
                    text = question.answer1.answer
                    setOnClickListener {
                        listener.invoke(question.answer1, question)
                    }
                }
                answer2.apply {
                    text = question.answer2.answer
                    setOnClickListener {
                        listener.invoke(question.answer2, question)
                    }
                }
                answer3.apply {
                    text = question.answer3.answer
                    setOnClickListener {
                        listener.invoke(question.answer3, question)
                    }
                }
                answer4.apply {
                    text = question.answer4.answer
                    setOnClickListener {
                        listener.invoke(question.answer4, question)
                    }
                }
            }
        }
    }
}