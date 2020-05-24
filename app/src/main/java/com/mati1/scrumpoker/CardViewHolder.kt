package com.mati1.scrumpoker

import androidx.recyclerview.widget.RecyclerView
import com.mati1.scrumpoker.CardAdapter.CardClickListener
import com.mati1.scrumpoker.databinding.ItemCardBinding

class CardViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(card: Card, clickListener: CardClickListener) {
        binding.card = card
        binding.listener = clickListener
        binding.executePendingBindings()
    }
}
