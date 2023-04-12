package com.apa.accenture.examplemvvm.domain.model

import com.apa.accenture.examplemvvm.data.database.entities.QuoteEntity
import com.apa.accenture.examplemvvm.data.model.QuoteModel


data class Quote (
    val quote:String,
    val author:String
        )

fun QuoteModel.toDomain() = Quote(quote,author)
fun QuoteEntity.toDomain() = Quote(quote, author)