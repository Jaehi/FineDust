package com.applemango.finedust

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TempBuilder {

    val baseURL = "https://api.openweathermap.org/"

    val api : TempAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(TempAPI::class.java)
    }
}