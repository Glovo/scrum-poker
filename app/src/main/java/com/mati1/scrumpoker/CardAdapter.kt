package com.mati1.scrumpoker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mati1.scrumpoker.databinding.ItemCardBinding

class CardAdapter(
    private val clickListener: CardClickListener
) : ListAdapter<Card, CardViewHolder>(
    object : DiffUtil.ItemCallback<Card>() {
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean =
            oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) = holder
        .bind(getItem(position), clickListener)

    interface CardClickListener {
        fun onCardClick(card: Card)
    }
}
