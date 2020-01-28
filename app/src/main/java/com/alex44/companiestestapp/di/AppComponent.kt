package com.alex44.companiestestapp.di

import com.alex44.companiestestapp.di.modules.AppModule
import com.alex44.companiestestapp.di.modules.CiceroneModule
import com.alex44.companiestestapp.di.modules.ImageModule
import com.alex44.companiestestapp.di.modules.RepoModule
import com.alex44.companiestestapp.presenters.DetailPresenter
import com.alex44.companiestestapp.presenters.HomePresenter
import com.alex44.companiestestapp.presenters.MainPresenter
import com.alex44.companiestestapp.ui.activities.MainActivity
import com.alex44.companiestestapp.ui.adapters.HomeRVAdapter
import com.alex44.companiestestapp.ui.fragments.DetailFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ImageModule::class, CiceroneModule::class, RepoModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainActivity: MainPresenter)
    fun inject(presenter: HomePresenter)
    fun inject(homeRVAdapter: HomeRVAdapter)
    fun inject(detailFragment: DetailFragment)
    fun inject(presenter: DetailPresenter)

}