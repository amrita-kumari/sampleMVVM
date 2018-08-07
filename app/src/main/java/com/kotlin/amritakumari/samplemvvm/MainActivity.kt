package com.kotlin.amritakumari.samplemvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.kotlin.amritakumari.samplemvvm.data.generateProduct
import com.kotlin.amritakumari.samplemvvm.viewModel.CustomViewModelFactory
import com.kotlin.amritakumari.samplemvvm.viewModel.ProductListViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this,CustomViewModelFactory((application as ProductApp).getRepository())).get(ProductListViewModel::class.java)
        viewModel.getProducts().observe(this, Observer { t ->
            if (t != null) {
                val buffer = StringBuffer()
                for (product in t) {
                    buffer.append(product.productName).append(" ").append(product.price).append(" ").append(product.rating).append("\n")
                }
                txtProduct.text = buffer.toString()
            }
        })
        insertData()
    }

    private fun insertData() {
        Observable
                .timer(5000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .map<Any> { o -> (application as ProductApp).getDatabase()?.productDao()?.insertAll(generateProduct())  }
                .subscribe()
    }
}
