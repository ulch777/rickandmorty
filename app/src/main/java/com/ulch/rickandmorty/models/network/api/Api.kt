package com.ulch.rickandmorty.models.network.api

import com.ulch.rickandmorty.entities.responses.CharacterResponse
import com.ulch.rickandmorty.entities.responses.EpisodeResponse
import com.ulch.rickandmorty.entities.responses.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int? = null): Response<CharacterResponse>
    @GET("location")
    suspend fun getAllLocation(@Query("page") page: Int? = null): Response<LocationResponse>
    @GET("episode")
    suspend fun getAllEpisode(@Query("page") page: Int? = null): Response<EpisodeResponse>
}