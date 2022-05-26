package com.applemango.finedust.temp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TempDTO(
    @SerializedName("temp")
    val temp : Float
) : Serializable
