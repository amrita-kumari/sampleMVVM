package com.kotlin.amritakumari.samplemvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.persistence.room.Room
import android.content.Context
import android.util.Log
import com.kotlin.amritakumari.samplemvvm.data.AppDatabase
import com.kotlin.amritakumari.samplemvvm.data.entity.Product

class DataRepository private constructor(private  val database: AppDatabase){


    private var mObservableProducts: MediatorLiveData<List<Product>> = MediatorLiveData()

    init {
        mObservableProducts.addSource(database.productDao().loadProducts(),
                { productEntities ->
                        mObservableProducts.postValue(productEntities)
                })
    }

    fun loadProduct(): LiveData<List<Product>> {
        return mObservableProducts
    }

    companion object {

        @Volatile private var INSTANCE: DataRepository? = null

        fun getInstance(appDatabase : AppDatabase): DataRepository=
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: DataRepository(appDatabase).also { INSTANCE = it }
                }
    }

}