package com.hackathon.lienquan.di

import com.google.gson.GsonBuilder
import com.hackathon.lienquan.BuildConfig
import com.hackathon.lienquan.data.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single(named("logging")) { createLoggingInterceptor() }
    single(named("header")) { createHeaderInterceptor() }
    single { createOkHttpClient(get(named("logging")), get(named("header"))) }
    single { createAppRetrofit(get()) }
    single { createApiService(get()) }
}

const val TIMEOUT = 10

fun createLoggingInterceptor(): Interceptor =
    HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    }

fun createHeaderInterceptor(): Interceptor =
    Interceptor { chain ->
        val request = chain.request()
        val newUrl = request.url.newBuilder()
            .build()
        val newRequest = request.newBuilder()
            .url(newUrl)
            .method(request.method, request.body)
            .build()
        chain.proceed(newRequest)
    }

fun createOkHttpClient(
    logging: Interceptor,
    header: Interceptor
): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        .addInterceptor(header)
        .addInterceptor(logging)
        .build()

fun createAppRetrofit(
    okHttpClient: OkHttpClient
): Retrofit =
    Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .baseUrl("https://lienquan-hackathon.herokuapp.com/")
        .client(okHttpClient)
        .build()

fun createApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)