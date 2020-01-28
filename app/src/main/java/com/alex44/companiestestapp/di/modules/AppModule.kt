package com.alex44.companiestestapp.di.modules

import com.alex44.companiestestapp.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app : App) {

    @Provides
    fun app() = app

}