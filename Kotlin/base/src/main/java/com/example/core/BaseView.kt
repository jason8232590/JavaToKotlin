package com.example.core

interface BaseView<T> {
//    fun getPresenter(): T ;
    //in kotlin we can annouce abstract filed, and after it should override after implementing
    val presenter: T
}