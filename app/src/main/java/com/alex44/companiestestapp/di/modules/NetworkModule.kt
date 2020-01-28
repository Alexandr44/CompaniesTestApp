package com.alex44.companiestestapp.di.modules

import com.alex44.companiestestapp.App
import com.alex44.companiestestapp.common.interfaces.INetworkStatus
import com.alex44.companiestestapp.common.ui.NetworkStatus
import dagger.Module
import dagger.Provides

@Module(includes = [AppModule::class])
class NetworkModule {

    @Provides
    fun networkStatus(app : App) : INetworkStatus = NetworkStatus(app)

}