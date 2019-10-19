package com.hackathon.lienquan.data

import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @SerializedName("result")
    val categories: List<Category>
)
