package com.hackathon.lienquan.data

import com.hackathon.lienquan.data.remote.response.ProductsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("category")
    fun getCategory(): Single<CategoryResponse>

    @GET("product")
    fun getProductsByIdCategory(@Query("categoryId") categoryId: String?): Single<ProductsResponse>
}