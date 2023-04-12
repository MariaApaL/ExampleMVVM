package com.apa.accenture.examplemvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {


//instancia de retrofit
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
                //ruta fija de nuestro endpoint
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}