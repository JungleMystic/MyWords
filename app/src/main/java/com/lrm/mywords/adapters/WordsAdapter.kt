package com.lrm.mywords.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.lrm.mywords.R
import com.lrm.mywords.WordsActivity

class WordsAdapter(context: Context, val letterId: String): RecyclerView.Adapter<WordsAdapter.WordsViewHolder>() {

    val wordsList = context.resources.getStringArray(R.array.words_list).toList()
    val filteredWords = wordsList
        .filter { it.startsWith(letterId, ignoreCase = true) }
        .shuffled()
        .take(5)
        .sorted()

    class WordsViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val button: Button = view.findViewById(R.id.button_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return WordsViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return filteredWords.size
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        val item = filteredWords[position]

        val context = holder.view.context

        holder.button.text = item
        holder.button.setOnClickListener {
            val queryUri: Uri = Uri.parse("${WordsActivity.SEARCH_PREFIX}$item")
            val intent = Intent(Intent.ACTION_VIEW, queryUri)
            context.startActivity(intent)
        }
    }
}