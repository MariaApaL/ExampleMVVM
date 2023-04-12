package com.apa.accenture.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apa.accenture.examplemvvm.data.model.QuoteModel
import com.apa.accenture.examplemvvm.domain.GetQuotesUseCase
import com.apa.accenture.examplemvvm.domain.GetRandomQuoteUseCase
import com.apa.accenture.examplemvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase

) : ViewModel() {
    //Pone las citas en la interfaz
    val quoteModel = MutableLiveData<Quote>()

    //Para el progress bar
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        //nos permite crear una corrutina que se controla sola
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            //Si hay un listado de quoteModel y no es nulo ni vacio,
            //muestra la primera quote del listado (para que no
            //aparezca la pantalla sin nada al iniciar la app)
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }

    }


}