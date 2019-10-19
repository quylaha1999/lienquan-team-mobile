package com.hackathon.lienquan.data

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("category")
    fun getCategory() : Single<CategoryResponse>
}