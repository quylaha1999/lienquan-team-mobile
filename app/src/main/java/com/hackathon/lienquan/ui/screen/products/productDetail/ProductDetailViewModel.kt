package com.hackathon.lienquan.ui.screen.products.productDetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.data.repository.CloudRepository
import com.hackathon.lienquan.ui.base.BaseViewModel
import com.hackathon.lienquan.utils.BaseSchedulerProvider

class ProductDetailViewModel(
    private val schedulerProvider: BaseSchedulerProvider,
    val repository: CloudRepository
) : BaseViewModel() {
    val product = MutableLiveData<Product>()

    fun addProduct(product: Product) {
        addDisposable(repository.insert(product)
            .observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribe(

            )
        )
        repository.insert(product)
    }
}