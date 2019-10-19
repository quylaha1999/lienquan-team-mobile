package com.hackathon.lienquan.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.text.NumberFormat
import java.util.*

@Parcelize
data class Product(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("des")
    val des: String? = null,
    @SerializedName("img")
    val img: String? = null,
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("sale")
    val sale: Int? = null,
    @SerializedName("createDate")
    val createDate: String? = null,
    @SerializedName("rate")
    val rate: String? = null,
    @SerializedName("categoryId")
    val categoryId: String? = null
) : Parcelable {
    fun convertPrice(): String? {
        return  NumberFormat.getNumberInstance(Locale.GERMAN).format(price) + "vnđ"
    }

}