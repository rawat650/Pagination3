package com

import androidx.paging.PagingSource
import androidx.paging.PagingState

class QuotesPagingSource(val apiService: ApiService) : PagingSource<Int, Result>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        try {
            val position = params.key ?: 1
            val response = apiService.getQuotes(position)
            return LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1


            )


        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
//        return super.getRefreshKey(state)
     if(state.anchorPosition!=null){
         val page = state.closestPageToPosition(state.anchorPosition!!)
         if(page?.prevKey!=null){
             return page.nextKey!!.plus(1)
         }
         else if(page?.nextKey!=null){
             return page.nextKey!!.minus(1)
         }

     }
        return null

    }
}