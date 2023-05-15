package com.lrm.mywords.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.lrm.mywords.R
import com.lrm.mywords.WordsActivity

class LettersAdapter(): RecyclerView.Adapter<LettersAdapter.LetterViewHolder>() {

    val lettersList = ('A').rangeTo('Z').toList()

    class LetterViewHolder(view: View): RecyclerView.ViewHolder(view){
        val button: Button = view.findViewById(R.id.button_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return LetterViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return lettersList.size
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = lettersList[position]
        holder.button.text = item.toString()
        holder.button.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, WordsActivity::class.java)
            intent.putExtra(WordsActivity.LETTER, holder.button.text.toString())
            context.startActivity(intent)
        }
    }
}