package com.ulch.rickandmorty.repository

import androidx.paging.PagingData
import com.ulch.rickandmorty.base.BaseRepository
import com.ulch.rickandmorty.entities.responses.CharacterData
import com.ulch.rickandmorty.entities.responses.EpisodeData
import com.ulch.rickandmorty.entities.responses.LocationData

import kotlinx.coroutines.flow.Flow

interface Repository : BaseRepository {

    suspend fun getAllCharacters(): Flow<PagingData<CharacterData>>
    suspend fun getAllLocations(): Flow<PagingData<LocationData>>
    suspend fun getAllEpisodes(): Flow<PagingData<EpisodeData>>

}