package com.firatveral.cakelist.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import com.firatveral.cakelist.CakeApp
import com.firatveral.cakelist.R
import com.firatveral.cakelist.data.Source.CakeService
import com.firatveral.cakelist.data.model.Cake
import com.firatveral.cakelist.utils.ItemDecorator
import com.firatveral.cakelist.utils.ViewUtils
import com.firatveral.cakelist.utils.cakeApp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    @Inject
    lateinit var mainPresenter: MainPresenter

    @Inject
    lateinit var apiService: CakeService


    private val cakesAdapter: CakeAdapter = CakeAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        cakeApp.component.inject(this)

        mainPresenter.attach(this)

        mainPresenter.loadData(apiService, Schedulers.io(), AndroidSchedulers.mainThread())


    }


    override fun showProgress(show: Boolean) {

        if (show) {
            progress.visibility = View.VISIBLE
        } else {

            progress.visibility = View.GONE
        }

    }

    override fun showErrorMessage(error: String) {

        Log.v(TAG, error)
    }

    override fun loadDataSuccess(cakeList: List<Cake>) {

        cakesAdapter.updateCakes(cakeList)
    }


    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.unsubscribe()
        mainPresenter.detach()
    }

    private fun initViews() {
        val gridColumnsSize = ViewUtils.calculateNoOfColumns(this)
        val gridLayoutManager = GridLayoutManager(this,gridColumnsSize)
        val itemDecorator = ItemDecorator(10, gridColumnsSize)
        CakeRV.layoutManager = gridLayoutManager
        CakeRV.addItemDecoration(itemDecorator)
        CakeRV.adapter = cakesAdapter

    }


}
