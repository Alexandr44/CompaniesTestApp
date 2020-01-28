package com.alex44.companiestestapp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface DetailView : MvpView {

    fun setName(name : String)

    fun setImage(photoUrl : String)

    fun setDescription(description : String)

    fun setLatitude(latitude : Double)

    fun setLongitude(longitude : Double)

    fun setSite(site : String)

    fun setPhone(phone : String)

    fun showMessage(message: String)

}