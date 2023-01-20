package com.ulch.rickandmorty.entities.responses


data class CharacterResponse(
    val info: Info,
    val results: List<CharacterData>
)