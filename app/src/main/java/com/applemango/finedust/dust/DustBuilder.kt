package com.applemango.finedust.dust

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DustBuilder {
    val baseURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/"

    val gson : Gson = GsonBuilder()
            .setLenient()
            .create()

    fun buildRetrofit() : Retrofit{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        return Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

    }


}