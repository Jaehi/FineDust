package com.applemango.finedust

import android.util.Log
import com.applemango.finedust.dust.DustAPI
import com.applemango.finedust.dust.DustBuilder
import com.applemango.finedust.dust.DustResponse
import com.applemango.finedust.temp.TempBuilder
import com.applemango.finedust.temp.TempResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ServerConnector {
    private val Tserver = TempBuilder.api
    private val Dserver = DustBuilder.buildRetrofit().create(DustAPI::class.java)

    fun getTemp(appId: String, q: String, lang: String, callback: (TempResponse) -> Unit) {
        Tserver.getTemp(appId, q, lang).enqueue() {
            callback(it)
            Log.d("getTemp Test", "$it")
        }

    }

    fun getDust(
        serviceKey: String,
        returnType: String,
        searchDate: String,
        callback: (DustResponse) -> Unit
    ) {
        Dserver.getDust(serviceKey, returnType, searchDate).enqueue() {
            callback(it)
            Log.d("getDust Test", "$it")
        }
    }


    private inline fun <T> Call<T>.enqueue(crossinline function: (body: T) -> Unit) {
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.body() == null) {
                    Log.d("Null", "onResponse: ")
                } else
                    function(response.body()!!)

            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.d("Fail", "$t")
            }
        })
    }
}