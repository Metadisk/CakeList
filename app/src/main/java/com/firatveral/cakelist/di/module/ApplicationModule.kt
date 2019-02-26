package com.firatveral.cakelist.di.module

import com.firatveral.cakelist.CakeApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val cakeApp: CakeApp) {

    @Provides
    @Singleton
    fun provideApp() = cakeApp

}