package com.ulch.rickandmorty.models

import com.ulch.rickandmorty.base.IBaseDiffModel

class EpisodeModel(
    override val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<String>
) : IBaseDiffModel