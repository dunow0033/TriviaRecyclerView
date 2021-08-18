package com.example.triviarecyclerview_august9.ui.trivia.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.triviarecyclerview_august9.databinding.FragmentTriviaBinding
import com.example.triviarecyclerview_august9.model.models.Answer
import com.example.triviarecyclerview_august9.model.models.Question
import com.example.triviarecyclerview_august9.ui.adapters.TriviaAdapter
import com.example.triviarecyclerview_august9.ui.trivia.viewmodel.TriviaViewModel

class TriviaFragment : Fragment() {

    private var _binding: FragmentTriviaBinding? = null
    private val binding: FragmentTriviaBinding get() = _binding!!

    private val viewModel: TriviaViewModel by activityViewModels()

    private val triviaAdapter: TriviaAdapter by lazy {
        TriviaAdapter(this::onAnswerSelected)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTriviaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.triviaRv.apply {
            adapter = triviaAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }

        viewModel.questions.observe(viewLifecycleOwner, Observer { questions ->
            triviaAdapter.setItems(questions)
        })
    }

    private fun onAnswerSelected(answer: Answer, question: Question) {
        viewModel.deleteQuestion(question)
        viewModel.onAnswerSelected(answer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}