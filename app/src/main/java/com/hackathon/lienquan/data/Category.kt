package com.hackathon.lienquan.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("img")
    val imageUrl: String? = null,
    @SerializedName("id")
    val id: String
) : Parcelable
