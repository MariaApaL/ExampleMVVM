package com.apa.accenture.examplemvvm.domain

import com.apa.accenture.examplemvvm.data.model.QuoteModel
import com.apa.accenture.examplemvvm.data.QuoteRepository
import com.apa.accenture.examplemvvm.data.database.entities.toDatabase
import com.apa.accenture.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    //Esto hace que repository siempre devuelva esta funcion
    //sin necesidad de llamarlo QuoteRepository.blabla
//            suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()


    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }

    }
}