package com.kotlin.amritakumari.samplemvvm

import android.app.Application
import com.kotlin.amritakumari.samplemvvm.data.AppDatabase

class ProductApp : Application() {

    fun getDatabase(): AppDatabase {
        return AppDatabase.getInstance(this)
    }

    fun getRepository(): DataRepository {
        return DataRepository.getInstance(getDatabase())
    }
}