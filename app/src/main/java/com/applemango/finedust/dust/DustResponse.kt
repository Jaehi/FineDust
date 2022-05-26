package com.applemango.finedust.dust

import com.google.gson.annotations.SerializedName

data class DustResponse(
    @SerializedName("response")
    var body : BodyResponse
)
