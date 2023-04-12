package com.apa.accenture.examplemvvm.data.network

import com.apa.accenture.examplemvvm.core.RetrofitHelper
import com.apa.accenture.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//Cuando se le pida al repositorio que nos de la cita, el repositorio decidirá
//si lo saca de la bbdd o de internet. Si es de internet, llamará a esta clase
//para devolver el servicio de internet

class QuoteService @Inject constructor(private val api: QuoteApiClient) {

    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes()
             response.body() ?: emptyList()
        }
    }

}