package com.hackathon.lienquan.di

import android.content.Context
import androidx.room.Room
import com.hackathon.lienquan.data.Constants
import com.hackathon.lienquan.data.local.room.AppDatabase
import com.hackathon.lienquan.data.remote.FirestoreHelper
import com.hackathon.lienquan.data.remote.FirestoreHelperImpl
import org.koin.dsl.module

val databaseModule = module {
    single<FirestoreHelper> { FirestoreHelperImpl() }
    single { createDatabase(get()) }
    single { createDataDao(get()) }
}

fun createDatabase(context: Context): AppDatabase =
    Room.databaseBuilder(context, AppDatabase::class.java, Constants.DATABASE_NAME).build()

fun createDataDao(database: AppDatabase) = database.dataDao()