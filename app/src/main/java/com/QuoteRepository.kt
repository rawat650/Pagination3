package com

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class QuoteRepository(val apiService: ApiService) {
    fun getQuotes() =Pager(
        config = PagingConfig(5,100),
        pagingSourceFactory = {
            QuotesPagingSource(apiService)
        }
    ).liveData
}