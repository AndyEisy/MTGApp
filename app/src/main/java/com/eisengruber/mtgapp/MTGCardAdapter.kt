package com.eisengruber.mtgapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class MTGCardAdapter(
    var cardList: List<Card>,
    var context: Context) : Adapter<MTGCardAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textViewCardName : TextView = itemView.findViewById(R.id.textViewCardName)
        var textViewCMCList : TextView = itemView.findViewById(R.id.textViewCMC)
        var textViewColors : TextView = itemView.findViewById(R.id.textViewColors)
        var textViewManaCost : TextView = itemView.findViewById(R.id.textViewManaCost)
        var textViewType : TextView = itemView.findViewById(R.id.textViewType)
        var textViewText : TextView = itemView.findViewById(R.id.textViewText)
        var imageViewCardImage : ImageView = itemView.findViewById(R.id.imageViewCardImage)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(context).inflate(R.layout.card_design,parent,false))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        var card = cardList[position]
        holder.textViewCardName.text = card.cardName
        holder.textViewCMCList.text = card.convertedManaCost.toString()
        holder.textViewColors.text = card.colors.toString()
        holder.textViewManaCost.text = card.manaCost
        holder.textViewType.text = card.type
        holder.textViewText.text = card.text
        

//        for (i in 0 until cardList.colors.size) {
//            holder.textViewText.colors.text.append(cardList[i].toString())
//        }


    }

    override fun getItemCount(): Int {
        return cardList.size
    }


}