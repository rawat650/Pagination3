package com

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn

class QuoteViewModel(val repository: QuoteRepository):ViewModel() {
    val list = repository.getQuotes().cachedIn(viewModelScope)

}