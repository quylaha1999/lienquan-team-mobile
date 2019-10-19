package com.hackathon.lienquan.ui.screen.home

import androidx.lifecycle.MutableLiveData
import com.hackathon.lienquan.data.Category
import com.hackathon.lienquan.data.CategoryResponse
import com.hackathon.lienquan.data.repository.CloudRepository
import com.hackathon.lienquan.ui.base.BaseViewModel
import com.hackathon.lienquan.utils.BaseSchedulerProvider

class HomeViewModel(
    private val schedulerProvider: BaseSchedulerProvider,
    private val repository: CloudRepository
) : BaseViewModel() {

    val categories = MutableLiveData<List<Category>>()

    fun getCategories() {
        repository.getCategories().observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribe({ data ->
                handleData(data)
            })
    }

    fun handleData(data: CategoryResponse) {
        this.categories.value = data.categories
    }
}
