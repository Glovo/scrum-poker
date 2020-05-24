package com.mati1.scrumpoker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CardAdapter.CardClickListener {

    private val cardsData = MutableLiveData<List<Card>>()
    private val cardsAdapter = CardAdapter(this)
    private val cardSelected = MutableLiveData<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cards.adapter = cardsAdapter

        cardsData.observe(this, Observer { cardsAdapter.submitList(it) })
        cardsData.postValue(listOf(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144).map { Card(it.toString()) })

        cardSelected.observe(this, Observer {
            selected_card_title.text = it.title

            motion.setTransition(R.id.select_card)
            motion.transitionToEnd()
        })
    }

    override fun onCardClick(card: Card) = cardSelected.postValue(card)
}
