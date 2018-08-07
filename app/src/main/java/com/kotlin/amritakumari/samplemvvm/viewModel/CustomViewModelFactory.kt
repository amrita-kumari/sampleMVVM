package com.kotlin.amritakumari.samplemvvm.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kotlin.amritakumari.samplemvvm.DataRepository

class CustomViewModelFactory(private val repository: DataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListViewModel(repository) as T
    }
}