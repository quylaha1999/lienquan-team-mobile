package com.hackathon.lienquan.di

import com.hackathon.lienquan.data.remote.FirestoreHelper
import com.hackathon.lienquan.data.remote.FirestoreHelperImpl
import org.koin.dsl.module

val databaseModule = module {
    single<FirestoreHelper> { FirestoreHelperImpl() }
}