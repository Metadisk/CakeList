package com.firatveral.cakelist.di.module

import com.firatveral.cakelist.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun providesMainPresenter() = MainPresenter()


}