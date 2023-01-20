package com.ulch.rickandmorty.models

import com.ulch.rickandmorty.base.IBaseDiffModel

data class LocationModel(
    override val id: Int,
    val dimension: String,
    val name: String,
    val type: String,
): IBaseDiffModel
