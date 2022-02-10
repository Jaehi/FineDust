package com.applemango.finedust

import com.google.gson.annotations.SerializedName

data class TempResponse(
    @SerializedName("main")
    val main : TempDTO?
)
