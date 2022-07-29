package com.eisengruber.mtgapp

import RetrofitClientInstance.retrofitInstance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the cards from internet
        callGetCards()
    }

    private fun callGetCards() {

        val service: APIService? = retrofitInstance?.create(APIService::class.java)
        service?.let{
            val call: Call<CardResponse> = service.getCards()

            call.enqueue(object : Callback<CardResponse> {

                override fun onResponse(call: Call<CardResponse>, response: Response<CardResponse>) {
                    val responseCards = response.body()?.cards
                    responseCards?.let { magicCards ->
                        doSomethingWithCardData(magicCards)
                    }
                }

                override fun onFailure(call: Call<CardResponse>, t: Throwable) {
                    val test = t
                    test
                }
            })
        }
    }

    private fun doSomethingWithCardData(card: List<Card>) {
        val testName = card.first().cardName
        testName
    }
}
