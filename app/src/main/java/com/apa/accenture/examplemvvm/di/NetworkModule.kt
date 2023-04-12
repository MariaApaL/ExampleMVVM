package com.apa.accenture.examplemvvm.di

import com.apa.accenture.examplemvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Para dependencias de librerias o clases de interfaces
@Module //Provee dependencias
@InstallIn(SingletonComponent::class) //alcances de las instancias (cuando quiero que muera)
object NetworkModule {

    //Mantiene solo 1 instancia de retrofit, para que no cree una diferente
    //cada evz que se le llama
    @Singleton
    //nos provee retrofit
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            //ruta fija de nuestro endpoint
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}