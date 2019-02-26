package com.firatveral.cakelist.di.module

import com.firatveral.cakelist.data.Source.NetworkApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkAPIModule {

    @Provides
    @Singleton
    fun provideNetworkApiService() = NetworkApi.create()
}