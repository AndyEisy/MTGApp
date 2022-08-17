package com.eisengruber.mtgapp

import RetrofitClientInstance.retrofitInstance
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment: Fragment(R.layout.search_fragment) {

    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

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
        val adapter = MTGCardAdapter(cards, requireActivity().applicationContext)
        recyclerView.adapter = adapter
    }
}
