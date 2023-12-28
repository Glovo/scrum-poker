package com.mati1.scrumpoker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.mati1.scrumpoker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CardAdapter.CardClickListener {

    private val cardsData = MutableLiveData<List<Card>>()
    private val cardsAdapter = CardAdapter(this)
    private val cardSelected = MutableLiveData<Card>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cards.adapter = cardsAdapter

        cardsData.observe(this, Observer { cardsAdapter.submitList(it) })
        cardsData.postValue(listOf(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144).map { Card(it.toString()) })

        cardSelected.observe(this, Observer {
            binding.selectedCardTitle.text = it.title

            binding.motion.setTransition(R.id.select_card)
            binding.motion.transitionToEnd()
        })
    }

    override fun onCardClick(card: Card) = cardSelected.postValue(card)
}
