package com.applemango.finedust.dust

import com.google.gson.annotations.SerializedName

data class BodyResponse(
    @SerializedName("body")
    var item : ItemsResponse
)
