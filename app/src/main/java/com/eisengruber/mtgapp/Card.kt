package com.eisengruber.mtgapp

import com.google.gson.annotations.SerializedName

class Card {

    @SerializedName("name")
    private val cardName: String? = null

    @SerializedName("cmc")
    private val convertedManaCost: Int? = null
}
