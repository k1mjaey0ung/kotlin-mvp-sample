package com.jaeyoung.myapplication.data.domain

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("id") val id: Int,
    @SerializedName("employee_name") val name: String,
    @SerializedName("employee_salary") val salary: String
)
