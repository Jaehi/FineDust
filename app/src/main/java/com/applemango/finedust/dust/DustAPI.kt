package com.applemango.finedust.dust

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DustAPI {

    @GET("getMinuDustFrcstDspth")
    fun getDust(
        @Query("serviceKey") serviceKey: String,
        @Query("returnType") returnType: String,
        @Query("searchDate") searchDate: String
    ):Call<DustResponse>
}