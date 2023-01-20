package com.ulch.rickandmorty.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ulch.rickandmorty.data.handle
import com.ulch.rickandmorty.entities.responses.CharacterData
import com.ulch.rickandmorty.models.network.api.Api

class CharactersDataSource(private val api: Api): PagingSource<Int, CharacterData>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterData> {
        val pageNumber = params.key ?: 1

        return try {
            val response =
                api.getAllCharacters(
                    page = pageNumber,
                ).handle()

            var nextPageNumber: Int? = null

            val results = response.data?.results

            if (response.data?.info?.next != null) {
                val uri = Uri.parse(response.data.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }
            if (results != null){
                LoadResult.Page(
                    data = results,
                    prevKey = if (pageNumber == 1) null else pageNumber - 1,
                    nextKey = nextPageNumber
                )
            } else {
                LoadResult.Error(Throwable("Character list is null :("))
            }



        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterData>): Int? {
        return null
    }
}