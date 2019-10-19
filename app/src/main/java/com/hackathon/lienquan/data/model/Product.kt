package com.hackathon.lienquan.data.model

import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.hackathon.lienquan.utils.convertToDateOnly
import kotlinx.android.parcel.Parcelize
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Entity(tableName = "product")
@Parcelize
data class Product(
    @PrimaryKey
    @ColumnInfo(name = "id")
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
    val rate: Float? = null,
    @SerializedName("categoryId")
    val categoryId: String? = null
) : Parcelable {
    fun convertPrice(): String? {
        return NumberFormat.getNumberInstance(Locale.GERMAN).format(price) + " vnđ"
    }

    fun convertDate(): String? {
        return createDate?.let { convertToDateOnly(it) }
    }

}