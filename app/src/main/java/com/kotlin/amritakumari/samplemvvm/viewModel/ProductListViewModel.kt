package com.kotlin.amritakumari.samplemvvm.viewModel

import android.arch.lifecycle.*
import com.kotlin.amritakumari.samplemvvm.DataRepository
import com.kotlin.amritakumari.samplemvvm.data.entity.Product

class ProductListViewModel(private val repository: DataRepository) : ViewModel() {

    private var mObservableProducts = MediatorLiveData<List<Product>>()

    init {
           fetchProduct()
    }

    private fun fetchProduct() {
        val products = repository.loadProduct()
        mObservableProducts.addSource(products, { mObservableProducts.setValue(it) })
    }

    fun getProducts(): LiveData<List<Product>>{
        return mObservableProducts
    }
}