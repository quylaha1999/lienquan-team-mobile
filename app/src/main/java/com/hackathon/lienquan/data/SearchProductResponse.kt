package com.hackathon.lienquan.data

import com.google.gson.annotations.SerializedName
import com.hackathon.lienquan.data.model.Product

data class SearchProductResponse (
    @SerializedName("result")
    val searchProductList: List<Product>
)
