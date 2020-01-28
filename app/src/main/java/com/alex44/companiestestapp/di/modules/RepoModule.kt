package com.alex44.companiestestapp.di.modules

import dagger.Module

@Module(includes = [ApiModule::class, NetworkModule::class])
class RepoModule {

}