package com.hackathon.lienquan.ui.screen.products.productDetail

import androidx.lifecycle.MutableLiveData
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.ui.base.BaseViewModel

class ProductDetailViewModel : BaseViewModel(){
    val product = MutableLiveData<Product>()

}