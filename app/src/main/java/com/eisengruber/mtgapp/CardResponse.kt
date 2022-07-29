package com.eisengruber.mtgapp

import com.google.gson.annotations.SerializedName

class CardResponse {
    @SerializedName("cards")
    private val cards: List<Card>? = null
}
