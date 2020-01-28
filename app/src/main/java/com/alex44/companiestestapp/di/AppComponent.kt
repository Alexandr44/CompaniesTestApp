package com.alex44.companiestestapp.di

import com.alex44.companiestestapp.di.modules.AppModule
import com.alex44.companiestestapp.di.modules.CiceroneModule
import com.alex44.companiestestapp.di.modules.ImageModule
import com.alex44.companiestestapp.presenters.MainPresenter
import com.alex44.companiestestapp.ui.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ImageModule::class, CiceroneModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainActivity: MainPresenter)

}