package com.hackathon.lienquan.ui.screen.main

import com.hackathon.lienquan.ui.base.BaseViewModel
import com.hackathon.lienquan.utils.BaseSchedulerProvider

class MainViewModel(private val schedulerProvider: BaseSchedulerProvider) : BaseViewModel() {

    fun sum(a: Int, b: Int): Int {
        if (a == 2) {
            return 0
        }
        return a.plus(b)
    }
}