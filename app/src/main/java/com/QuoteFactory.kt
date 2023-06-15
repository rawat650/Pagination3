package com

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuoteFactory (val repository: QuoteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(repository) as T
    }
}