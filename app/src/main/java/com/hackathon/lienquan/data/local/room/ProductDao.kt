package com.hackathon.lienquan.data.local.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.hackathon.lienquan.data.model.Product
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Product): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categories: List<Product>):Completable

    @Delete
    fun delete(category: Product):Completable

    @Update
    fun update(category: Product):Completable

    @Query("SELECT * FROM product")
    fun getCategories(): Observable<List<Product>>
}