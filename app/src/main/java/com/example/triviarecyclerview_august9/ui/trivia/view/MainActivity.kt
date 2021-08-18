package com.example.triviarecyclerview_august9.ui.trivia.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.triviarecyclerview_august9.databinding.ActivityMainBinding
import com.example.triviarecyclerview_august9.ui.trivia.viewmodel.TriviaViewModel

class MainActivity : FragmentActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: TriviaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.score.observe(this, Observer { score ->
            binding.countTv.text = score.toString()
        })
    }
}