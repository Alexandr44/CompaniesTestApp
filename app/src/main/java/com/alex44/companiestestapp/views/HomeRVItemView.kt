package com.alex44.companiestestapp.views

interface HomeRVItemView {

    fun setCompanyName(name : String)

    fun setCompanyImage(imageUrl : String)

    fun getItemPosition() : Int

}