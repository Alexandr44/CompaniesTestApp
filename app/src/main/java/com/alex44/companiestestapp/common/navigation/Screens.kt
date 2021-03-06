package com.alex44.companiestestapp.common.navigation

import androidx.fragment.app.Fragment
import com.alex44.companiestestapp.ui.fragments.DetailFragment
import com.alex44.companiestestapp.ui.fragments.HomeFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class HomeScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = HomeFragment.newInstance()
    }

    class DetailScreen(val id : Int) : SupportAppScreen() {
        override fun getFragment(): Fragment = DetailFragment.newInstance(id)
    }

}