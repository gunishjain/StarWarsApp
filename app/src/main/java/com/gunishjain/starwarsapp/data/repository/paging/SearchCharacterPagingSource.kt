package com.gunishjain.starwarsapp.data.repository.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gunishjain.starwarsapp.data.api.NetworkService
import com.gunishjain.starwarsapp.data.model.Character
import com.gunishjain.starwarsapp.utils.AppConstant

class SearchCharacterPagingSource(
    private val networkService: NetworkService,
    private val query: String
) :
    PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: AppConstant.INITIAL_PAGE

            val response = networkService.searchCharacterList(
                query = query,
                page = page
            )
            Log.d("JAIN", response.characters.size.toString())

            LoadResult.Page(
                data = response.characters,
                prevKey = if (page == AppConstant.INITIAL_PAGE) null else page.minus(1),
                nextKey = if (response.characters.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }


}