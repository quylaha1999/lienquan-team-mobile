package com.hackathon.lienquan.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hackathon.lienquan.data.model.Data
import com.hackathon.lienquan.data.model.Product

@Database(entities = [Data::class, Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao

    abstract fun productDao(): ProductDao
}