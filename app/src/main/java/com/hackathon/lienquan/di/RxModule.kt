package com.hackathon.lienquan.di

import com.hackathon.lienquan.utils.BaseSchedulerProvider
import com.hackathon.lienquan.utils.SchedulerProvider
import org.koin.dsl.module

val rxModule = module {
    single<BaseSchedulerProvider> { SchedulerProvider() }
}