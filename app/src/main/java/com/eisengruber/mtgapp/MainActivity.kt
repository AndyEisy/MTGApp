package com.eisengruber.mtgapp

import RetrofitClientInstance.retrofitInstance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var recyclerView: RecyclerView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This is the new stuff added 8/1/2022
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

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

    private fun doSomethingWithCardData(cards: List<Card>) {
        val adapter = MTGCardAdapter(cards, applicationContext)
        recyclerView.adapter = adapter
    }
}
