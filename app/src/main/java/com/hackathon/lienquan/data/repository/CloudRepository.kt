package com.hackathon.lienquan.data.repository

import com.hackathon.lienquan.data.ApiService
import com.hackathon.lienquan.data.CategoryResponse
import com.hackathon.lienquan.data.SearchProductResponse
import com.hackathon.lienquan.data.local.room.ProductDao
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.data.remote.FirestoreHelper
import com.hackathon.lienquan.data.remote.response.ProductsResponse
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class CloudRepository(
    private val firestoreHelper: FirestoreHelper,
    private val apiService: ApiService,
    private val dao: ProductDao
) {
    fun getCategories(): Single<CategoryResponse> = apiService.getCategory()

    fun getProductsByIdCategory(categoryId: String?): Single<ProductsResponse> =
        apiService.getProductsByIdCategory(categoryId)

    fun getSearchProductResult(query: String): Single<SearchProductResponse> =
        apiService.getSearchProduct(query)

    fun insert(product: Product): Completable = dao.insert(product)
    fun insert(products: List<Product>): Completable = dao.insert(products)
    fun update(product: Product): Completable = dao.update(product)
    fun delete(product: Product): Completable = dao.delete(product)
    fun getAllProducts(): Observable<List<Product>> = dao.getCategories()
}