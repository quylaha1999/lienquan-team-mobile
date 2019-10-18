package com.hackathon.lienquan.data.local.assets

import android.content.Context

fun read(context: Context, source: String): String {
    return context.assets.open(source).bufferedReader().use { it.readText() }
}