package com.hackathon.lienquan.ui.screen.products

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.data.repository.CloudRepository
import com.hackathon.lienquan.ui.base.BaseViewModel
import com.hackathon.lienquan.utils.BaseSchedulerProvider

class ProductsViewModel(
    private val schedulerProvider: BaseSchedulerProvider,
    private val repository: CloudRepository
) : BaseViewModel() {
    val products = MutableLiveData<List<Product>>()

    @SuppressLint("CheckResult")
    fun getProductsByIdCategory(categoryId: String?) {
        repository.getProductsByIdCategory(categoryId)
            .observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribe { data ->
                products.value = data?.products
            }
    }
}