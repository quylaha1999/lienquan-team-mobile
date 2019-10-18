package com.hackathon.lienquan.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "data")
@Parcelize
data class Data(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int
) : Parcelable