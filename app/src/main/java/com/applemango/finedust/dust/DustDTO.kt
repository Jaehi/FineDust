package com.applemango.finedust.dust

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.lang.reflect.Array

data class DustDTO(
    @SerializedName("informGrade")
    val informGrade : String
):Serializable
