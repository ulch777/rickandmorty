package com.ulch.rickandmorty.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ulch.rickandmorty.entities.responses.CharacterData
import com.ulch.rickandmorty.entities.responses.EpisodeData
import com.ulch.rickandmorty.entities.responses.LocationData
import com.ulch.rickandmorty.models.network.api.Api
import com.ulch.rickandmorty.paging.CharactersDataSource
import com.ulch.rickandmorty.paging.EpisodeDataSource
import com.ulch.rickandmorty.paging.LocationDataSource
import kotlinx.coroutines.flow.Flow


class RepositoryImpl(private val api: Api) : Repository {

    override suspend fun getAllCharacters(): Flow<PagingData<CharacterData>> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = {
                CharactersDataSource(
                    api,
                )
            }
        ).flow
    }

    override suspend fun getAllLocations(): Flow<PagingData<LocationData>> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = {
                LocationDataSource(
                    api,
                )
            }
        ).flow
    }

    override suspend fun getAllEpisodes(): Flow<PagingData<EpisodeData>> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = {
                EpisodeDataSource(
                    api,
                )
            }
        ).flow
    }

}