package com.apa.accenture.examplemvvm.data

import com.apa.accenture.examplemvvm.data.database.dao.QuoteDao
import com.apa.accenture.examplemvvm.data.database.entities.QuoteEntity
import com.apa.accenture.examplemvvm.data.model.QuoteModel
import com.apa.accenture.examplemvvm.domain.model.toDomain
import com.apa.accenture.examplemvvm.data.network.QuoteService
import com.apa.accenture.examplemvvm.domain.model.Quote

import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao: QuoteDao

){


//    suspend fun getAllQuotesFromApi(): List<Quote>{
        //llama al backend y recupera las citas
//        val response = api.getQuotes()
//        //metemos la respuesta del servidor en el quoteprovider
//        quoteProvider.quotes = response
//        return response
//    }

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }

}