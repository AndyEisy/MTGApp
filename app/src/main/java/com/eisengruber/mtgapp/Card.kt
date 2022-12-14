package com.eisengruber.mtgapp

import com.google.gson.annotations.SerializedName

class Card {

    @SerializedName("name")
    val cardName: String? = null

    @SerializedName("cmc")
    val convertedManaCost: Int? = null

    @SerializedName("colors")
    val colors: ArrayList<String>? = null

    @SerializedName("manaCost")
    val manaCost: String? = null

    @SerializedName("type")
    val type: String? = null

    @SerializedName("text")
    val text: String? = null

    @SerializedName("imageUrl")
    val image: String? = null

}
