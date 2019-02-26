package com.firatveral.cakelist.ui.main

import com.firatveral.cakelist.data.Source.CakeService
import com.firatveral.cakelist.data.model.Cake
import com.firatveral.cakelist.ui.base.BaseContract
import io.reactivex.Scheduler


class MainContract {

    // presenter contract
    interface Presenter : BaseContract.Presenter<MainContract.View>
    {
        fun loadData(service: CakeService, processScheduler: Scheduler, androidScheduler: Scheduler)
    }

    //TODO view contract for MainActivity class , we will show a progress bar during data load , if any error happens  it will show error message
    interface View : BaseContract.View{

        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Cake>)

    }

}