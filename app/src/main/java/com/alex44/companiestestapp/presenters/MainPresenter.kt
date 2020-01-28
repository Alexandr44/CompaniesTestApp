package com.alex44.companiestestapp.presenters

import com.alex44.companiestestapp.common.navigation.Screens
import com.alex44.companiestestapp.views.MainView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        goToHomeScreen()
    }

    private fun goToHomeScreen() {
        router.newRootScreen(Screens.HomeScreen())
    }

}