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

        callGetCards()
    }

    private fun callGetCards() {

        val service: APIService? = retrofitInstance?.create(APIService::class.java)
        service?.let{
            val call: Call<CardResponse> = service.getCards()

            call.enqueue(object : Callback<CardResponse> {

                override fun onResponse(call: Call<CardResponse>, response: Response<CardResponse>) {
                    val test = response
                    test
                }

                override fun onFailure(call: Call<CardResponse>, t: Throwable) {
                    val test = t
                    test
                }
            })
        }
    }
}
