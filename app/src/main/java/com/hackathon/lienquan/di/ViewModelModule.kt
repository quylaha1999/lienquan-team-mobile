package com.hackathon.lienquan.di

import com.hackathon.lienquan.ui.screen.home.HomeViewModel
import com.hackathon.lienquan.ui.screen.main.MainViewModel
import com.hackathon.lienquan.ui.screen.products.ProductsViewModel
import com.hackathon.lienquan.ui.screen.products.productDetail.ProductDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { ProductsViewModel(get(), get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { ProductDetailViewModel() }

}