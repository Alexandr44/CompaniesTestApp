package com.alex44.companiestestapp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface HomeView : MvpView {

    fun initRV()

    fun updateRV()

    fun showMessage(message: String)
}