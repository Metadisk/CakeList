package com.firatveral.cakelist.ui.main

import com.firatveral.cakelist.data.Source.CakeService
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable


/**
 * TODO presenter class that will be used in Main activity , winn interact between model and view
 */
class MainPresenter() : MainContract.Presenter {

    private val mDisposable = CompositeDisposable()

    private var view: MainContract.View? = null

    //TODO  presenter method communicates with model
    override fun loadData(service: CakeService, processScheduler: Scheduler, androidScheduler: Scheduler) {

        mDisposable.add(service.getCakes().subscribeOn(processScheduler).observeOn(androidScheduler)
            .doOnSubscribe {
                view?.showProgress(true)
            }
            .subscribe({
                view?.showProgress(false)
                view?.loadDataSuccess(it.toList().distinct().sortedWith(compareBy{ it.title }))

            }, {
                view?.showProgress(false)
                view?.showErrorMessage(it.localizedMessage)
            }))

    }


    /**
     * TODO this method will do unsubscribe for disposable rx object
     */
    override fun unsubscribe() {

        mDisposable.clear()
    }


    /**
     * TODO  attach our view to the presenter
     */
    override fun attach(view: MainContract.View) {
        this.view = view
    }

    //TODO on destroy ccall this for preventing memory leaks
    override fun detach() {
        if(this.view != null)
        {
            this.view = null
        }
    }


}