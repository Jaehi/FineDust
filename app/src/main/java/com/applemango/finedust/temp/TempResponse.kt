package com.applemango.finedust.temp

import com.google.gson.annotations.SerializedName

data class TempResponse(
    @SerializedName("main")
    val main : TempDTO?
)
