package com.apa.accenture.examplemvvm.domain

import com.apa.accenture.examplemvvm.data.QuoteRepository
import com.apa.accenture.examplemvvm.data.model.QuoteModel
import com.apa.accenture.examplemvvm.domain.model.Quote
import javax.inject.Inject


class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {


    //no es una corrutina porque lo tenemos en memoria, no en bbdd
   suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
//            val randomNumber= (quotes.indices).random()
            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}