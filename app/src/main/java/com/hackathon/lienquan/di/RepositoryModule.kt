package com.hackathon.lienquan.di

import com.hackathon.lienquan.data.repository.CloudRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { CloudRepository(get(), get()) }
}