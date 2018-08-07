package com.kotlin.amritakumari.samplemvvm.data

import android.util.Log
import com.kotlin.amritakumari.samplemvvm.data.entity.Product
import java.util.*

private val productName = listOf("Apple","Android","Samsung","Nokia","Microsoft")

fun generateProduct() : MutableList<Product> {
    val productList = mutableListOf<Product>()
    val rnd = Random()
    for (name in productName){
        val product = Product(0,name, rnd.nextInt(240), rnd.nextInt(5))
        productList.add(product)
    }
    return productList
}

