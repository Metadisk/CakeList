package com.firatveral.cakelist.ui.main

import android.support.test.espresso.matcher.ViewMatchers.assertThat
import com.firatveral.cakelist.data.Source.CakeService
import com.firatveral.cakelist.data.model.Cake
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class MainPresenterTest {


    @Mock
    lateinit var mockService: CakeService


    @Mock
    lateinit var view: MainContract.View

    @Mock
    var mockedList: List<Cake>? = null


    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun test_LoadData() {


        // Given
        val data = Cake( "" ,"","")
        val observable = Observable.just(listOf(data))
        val mainPresenter = MainPresenter()
        val scheduler = TestScheduler()
        // When
        Mockito.`when`(mockService.getCakes()).thenReturn(observable)
        mainPresenter.loadData(mockService, scheduler,scheduler)


        // Then
        verify(view, times(1)).showProgress(Mockito.anyBoolean())
        verify(view, times(1)).loadDataSuccess(listOf(data))
        verify(view ,never()).showErrorMessage(Mockito.any())



    }
}
