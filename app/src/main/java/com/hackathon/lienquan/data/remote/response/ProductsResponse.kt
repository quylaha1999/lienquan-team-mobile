package com.hackathon.lienquan.data.remote.response

import com.google.gson.annotations.SerializedName
import com.hackathon.lienquan.data.model.Product

data class ProductsResponse(
    @SerializedName("result")
    val products: List<Product>
)
