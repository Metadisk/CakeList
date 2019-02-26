package com.firatveral.cakelist.data.Source

import com.firatveral.cakelist.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  Network API for fetching data from remote data source
 */
class NetworkApi {

    companion object CakeApi {
        fun create(): CakeService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(CakeService::class.java)
        }
    }

}