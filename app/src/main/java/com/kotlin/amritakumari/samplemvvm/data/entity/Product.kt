package com.kotlin.amritakumari.samplemvvm.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Product")
data class Product( @PrimaryKey(autoGenerate = true)
                    val id: Int,
                   @ColumnInfo(name = "productName")  val productName : String = "",
                   @ColumnInfo(name = "price")  val price : Int = 0,
                   @ColumnInfo(name = "rating")  val rating : Int = 0)