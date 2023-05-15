package com.lrm.mywords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lrm.mywords.adapters.WordsAdapter
import com.lrm.mywords.databinding.ActivityWordsBinding

class WordsActivity : AppCompatActivity() {

    lateinit var binding: ActivityWordsBinding

    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.co.in/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWordsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letterId = intent?.extras?.getString(LETTER).toString()

        val recyclerView = binding.wordsRv
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordsAdapter(this, letterId)
    }
}