package com.eisengruber.mtgapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class MTGCardAdapter(
    var cardList: List<Card>,
    var context: Context) : Adapter<MTGCardAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textViewCardName : TextView = itemView.findViewById(R.id.textViewCardName)
        var textViewCMCList : TextView = itemView.findViewById(R.id.textViewCMC)
        var textViewColors: TextView = itemView.findViewById(R.id.textViewColors)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(context).inflate(R.layout.card_design,parent,false))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        var card = cardList[position]
        holder.textViewCardName.text = card.cardName
        holder.textViewCMCList.text = card.convertedManaCost.toString()
        holder.textViewColors.text = card.colors.toString()
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

}