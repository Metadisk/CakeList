package com.firatveral.cakelist.data.Source

import com.firatveral.cakelist.data.model.Cake
import io.reactivex.Observable
import retrofit2.http.GET

interface CakeService {

    @GET("waracle_cake-android-client/")
    fun getCakes(): Observable<List<Cake>>
}