package com.ulch.rickandmorty.entities.responses



data class LocationResponse(
    val info: Info,
    val results: List<LocationData>
)

