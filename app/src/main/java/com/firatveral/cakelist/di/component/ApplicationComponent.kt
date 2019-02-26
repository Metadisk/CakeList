package com.firatveral.cakelist.di.component

import com.firatveral.cakelist.CakeApp
import com.firatveral.cakelist.di.module.ApplicationModule
import com.firatveral.cakelist.di.module.HomeModule
import com.firatveral.cakelist.di.module.NetworkAPIModule
import com.firatveral.cakelist.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class),(HomeModule::class),(NetworkAPIModule::class)])
interface ApplicationComponent {

    fun inject(application: CakeApp)
    fun inject(activity: MainActivity)

}