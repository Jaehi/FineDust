package com.applemango.finedust

import com.google.gson.annotations.SerializedName

data class DustResponse(
    @SerializedName("response")
    var body : BodyResponse?
)
