package com.applemango.finedust

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("items")
    var itemlist : List<DustDTO>
)
