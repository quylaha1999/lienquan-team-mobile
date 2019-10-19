package com.hackathon.lienquan.data.repository

import com.hackathon.lienquan.data.ApiService
import com.hackathon.lienquan.data.CategoryResponse
import com.hackathon.lienquan.data.SearchProductResponse
import com.hackathon.lienquan.data.remote.FirestoreHelper
import com.hackathon.lienquan.data.remote.response.ProductsResponse
import io.reactivex.Single

class CloudRepository(
    private val firestoreHelper: FirestoreHelper,
    private val apiService: ApiService
) {
    fun getCategories(): Single<CategoryResponse> = apiService.getCategory()

    fun getProductsByIdCategory(categoryId: String?): Single<ProductsResponse> =
        apiService.getProductsByIdCategory(categoryId)

    fun getSearchProductResult(query: String): Single<SearchProductResponse> =
        apiService.getSearchProduct(query)
}