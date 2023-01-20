package com.ulch.rickandmorty.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ulch.rickandmorty.data.handle
import com.ulch.rickandmorty.entities.responses.EpisodeData
import com.ulch.rickandmorty.models.network.api.Api

class EpisodeDataSource (
    private val api: Api
) : PagingSource<Int, EpisodeData>() {
    override fun getRefreshKey(state: PagingState<Int, EpisodeData>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeData> {

        val pageNumber = params.key ?: 1

        return try {
            val response = api.getAllEpisode(pageNumber).handle()
            val episodeData = response.data

            var nextPageNumber: Int? = null

            if (response.data?.info?.next != null) {
                val uri = Uri.parse(response.data.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            if (episodeData != null){
                LoadResult.Page(
                    data = episodeData.results,
                    prevKey = if (pageNumber == 1) null else pageNumber - 1,
                    nextKey = nextPageNumber
                )
            } else {
                LoadResult.Error(Throwable("Episode list is null :("))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }


    }
}