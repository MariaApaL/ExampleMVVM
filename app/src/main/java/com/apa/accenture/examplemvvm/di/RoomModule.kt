package com.apa.accenture.examplemvvm.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.apa.accenture.examplemvvm.data.database.QuoteDatabase;


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {


     private const val QUOTE_DATABASE_NAME = "quote_database"


    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        //context, clase donde está la bbddd y un nombre para la base de datos
        Room.databaseBuilder(context, QuoteDatabase::class.java,QUOTE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db:QuoteDatabase) = db.getQuoteDao()

}