package com.ulch.rickandmorty.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ulch.rickandmorty.data.handle
import com.ulch.rickandmorty.entities.responses.LocationData
import com.ulch.rickandmorty.models.network.api.Api

class LocationDataSource(
    private val api: Api
) : PagingSource<Int, LocationData>() {

    override fun getRefreshKey(state: PagingState<Int, LocationData>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationData> {

        val pageNumber = params.key ?: 1

        return try {
            val response = api.getAllLocation(pageNumber).handle()
            val location = response.data

            var nextPageNumber: Int? = null

            if (location?.info?.next != null) {
                val uri = Uri.parse(location.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            if (location != null){
                LoadResult.Page(
                    data = location.results,
                    prevKey = if (pageNumber == 1) null else pageNumber - 1,
                    nextKey = nextPageNumber
                )
            } else {
                LoadResult.Error(Throwable("Location list is null :("))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }


    }
}