package com.alex44.companiestestapp.common.interfaces

interface IImageLoader<T> {

    fun loadInto(url : String, container : T, corners : Int)

}