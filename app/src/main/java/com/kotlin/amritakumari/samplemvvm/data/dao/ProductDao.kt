package com.kotlin.amritakumari.samplemvvm.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.kotlin.amritakumari.samplemvvm.data.entity.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun loadProducts(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<Product>)

}