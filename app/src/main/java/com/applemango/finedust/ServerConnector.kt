package com.applemango.finedust

import android.util.Log
import com.applemango.finedust.models.NewDustResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ServerConnector {
    private val Tserver = TempBuilder.api
    private val Dserver = DustBuilder.buildRetrofit().create(DustAPI::class.java)

    fun getTemp(appId: String, q: String, lang: String, callback: (TempResponse) -> Unit) {
        Tserver.getTemp(appId, q, lang).enqueue() {
            callback(it)
            Log.d("2222222222","$it")
        }

    }

    fun getDust(serviceKey: String, returnType: String, searchDate: String, callback: (NewDustResponse) -> Unit){
        Dserver.getDust(serviceKey,returnType,searchDate).enqueue(){
            callback(it)
            Log.d("555555555555","$it")
        }
    }



    private inline fun <T> Call<T>.enqueue(crossinline function: (body: T) -> Unit) {
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.body() == null) {
                    Log.d("Tlqkf", "onResponse: ")
                } else
                    function(response.body()!!)

            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.d("TLqkf", "$t")
            }
        })
    }
}