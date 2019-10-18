package com.hackathon.lienquan.data.local.prefs

interface SharePrefsApi {

    fun <T> get(key: String, clazz: Class<T>): T?

    fun <T> put(key: String, data: T)

    fun delete(key: String)

    fun clear()
}