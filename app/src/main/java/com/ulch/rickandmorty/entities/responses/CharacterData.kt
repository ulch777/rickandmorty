package com.ulch.rickandmorty.entities.responses

import androidx.paging.PagingData
import androidx.paging.map
import com.ulch.rickandmorty.models.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class CharacterData(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)


fun Flow<PagingData<CharacterData>>.toCharacterModel(): Flow<PagingData<CharacterModel>> {
    return map { pagingData ->
        pagingData.map { characterData ->
            CharacterModel(
                id = characterData.id,
                name = characterData.name,
                status = characterData.status,
                gender = characterData.gender,
                image = characterData.image,
                species = characterData.species
            )

        }
    }
}

