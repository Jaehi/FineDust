package com.applemango.finedust

import com.applemango.finedust.models.NewDustResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.format.DateTimeFormatter

interface DustAPI {

    @GET("getMinuDustFrcstDspth")
    fun getDust(
        @Query("serviceKey") serviceKey: String,
        @Query("returnType") returnType: String,
        @Query("searchDate") searchDate: String
    ):Call<NewDustResponse>
}