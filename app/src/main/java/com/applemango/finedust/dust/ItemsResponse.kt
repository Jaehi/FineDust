package com.applemango.finedust.dust

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("items")
    var itemlist : List<DustDTO>
)
