package com.ulch.rickandmorty.entities.responses

data class EpisodeResponse(
    val info: Info,
    val results: List<EpisodeData>
)