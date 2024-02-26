package com.example.apprickyandmorty.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.apprickyandmorty.R
import com.example.apprickyandmorty.databinding.CardBinding
import com.example.apprickyandmorty.data.model.Card
import com.example.apprickyandmorty.data.model.ResultX

class CardAdapter(private val card: List<ResultX>?): RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cards = card!!.get(position)
        holder.render(cards)
    }

    override fun getItemCount(): Int = card!!.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = CardBinding.bind(view)

        fun render (card: ResultX){
            binding.name.text = card.name
            Glide.with(context)
                .load(card.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.image)

        }
    }
}