package com.hackathon.lienquan.ui.screen.home

import com.hackathon.lienquan.data.repository.CloudRepository
import com.hackathon.lienquan.ui.base.BaseViewModel
import com.hackathon.lienquan.utils.BaseSchedulerProvider

class HomeViewModel(
    private val schedulerProvider: BaseSchedulerProvider,
    private val repository: CloudRepository
) : BaseViewModel() {
    fun getCategories() {
        val dispoable = repository.getCategories().observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribe()
    }
}
