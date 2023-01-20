package com.ulch.rickandmorty.entities.responses

import androidx.paging.PagingData
import androidx.paging.map
import com.ulch.rickandmorty.models.EpisodeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


data class EpisodeData(
    val id: Int,
    val name: String,
    val air_date: String,
    val characters: List<String>,
    val url: String,
    val episode: String,
    val created: String
)

fun Flow<PagingData<EpisodeData>>.toEpisodeModel(): Flow<PagingData<EpisodeModel>> {
    return map { pagingData ->
        pagingData.map { episodeData ->
            EpisodeModel(
                id = episodeData.id,
                name = episodeData.name,
                airDate = episodeData.air_date,
                episode = episodeData.episode,
                characters = episodeData.characters
            )

        }
    }
}
