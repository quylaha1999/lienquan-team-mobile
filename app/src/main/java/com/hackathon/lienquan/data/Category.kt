package com.hackathon.lienquan.data

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("img")
    val imageUrl: String? = null,
    @SerializedName("id")
    val id: String? = null
)
