package com.firatveral.cakelist

import android.app.Application
import com.firatveral.cakelist.di.component.ApplicationComponent
import com.firatveral.cakelist.di.component.DaggerApplicationComponent
import com.firatveral.cakelist.di.module.ApplicationModule
import com.firatveral.cakelist.di.module.HomeModule
import com.firatveral.cakelist.di.module.NetworkAPIModule

class CakeApp : Application(){

    val component: ApplicationComponent by lazy {

        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .homeModule(HomeModule())
            .networkAPIModule(NetworkAPIModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}