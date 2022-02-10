package com.applemango.finedust

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TempAPI {

    @GET("data/2.5/weather?")

    fun getTemp(

        @Query("appid") appid : String,
        @Query("q") q : String,
        @Query("lang") lang : String

    ):Call<TempResponse>

}