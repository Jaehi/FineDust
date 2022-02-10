package com.applemango.finedust

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TempDTO(
    @SerializedName("temp")
    val temp : Float
) : Serializable
