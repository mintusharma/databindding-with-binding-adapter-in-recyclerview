package com.example.databindingwithretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyClient private constructor() {
    private val retrofit: Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val myApi: MyAPI
        get() = retrofit.create(MyAPI::class.java)

    companion object {
        private const val BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/"
        private var myClient: MyClient? = null

        @get:Synchronized
        val instance: MyClient?
            get() {
                if (myClient == null) {
                    myClient = MyClient()
                }
                return myClient
            }
    }

}