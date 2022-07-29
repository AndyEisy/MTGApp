package com.eisengruber.mtgapp

import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("cards")
    fun getCards(): Call<CardResponse>
}
