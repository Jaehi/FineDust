package com.applemango.finedust

import com.google.gson.annotations.SerializedName

data class BodyResponse(
    @SerializedName("body")
    var item : ItemsResponse?
)
