package com.jaeyoung.myapplication.data.response

import com.google.gson.annotations.SerializedName
import com.jaeyoung.myapplication.data.domain.Data

data class DataResponse (
    @SerializedName("status") val status: String,
    @SerializedName("data") val items: MutableList<Data>
)