package com.hackathon.lienquan.ui.screen.cart

import androidx.lifecycle.MutableLiveData
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.data.repository.CloudRepository
import com.hackathon.lienquan.ui.base.BaseViewModel
import com.hackathon.lienquan.utils.BaseSchedulerProvider

class CartViewModel(
    private val schedulerProvider: BaseSchedulerProvider,
    val repository: CloudRepository
) : BaseViewModel() {
    var products = MutableLiveData<List<Product>>()

    fun getProduct() {
        addDisposable(
            repository.getAllProducts()
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe({
                    products.value = it
                }
                )
        )
    }
}