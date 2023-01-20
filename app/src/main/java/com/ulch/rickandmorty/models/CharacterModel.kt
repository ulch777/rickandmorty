package com.ulch.rickandmorty.models

import com.ulch.rickandmorty.base.IBaseDiffModel


data class CharacterModel(
    override val id: Int,
    val name: String,
    val status: String,
    val gender: String,
    val image: String,
    val species: String,
): IBaseDiffModel