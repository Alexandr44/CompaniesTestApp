package com.alex44.companiestestapp.common.interfaces

import android.widget.ImageView

interface IImageLoader<T> {

    fun loadInto(url : String, container : T, corners : Int)

    fun loadIntoFromAssets(url: String, container: ImageView, corners: Int)
}