package com.ulch.rickandmorty.entities.responses

import androidx.paging.PagingData
import androidx.paging.map
import com.ulch.rickandmorty.models.LocationModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


data class LocationData(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)

fun Flow<PagingData<LocationData>>.toLocationModel(): Flow<PagingData<LocationModel>> {
    return map { pagingData ->
        pagingData.map { locationData ->
            LocationModel(
                id = locationData.id,
                name = locationData.name,
                type = locationData.type,
                dimension = locationData.dimension,
            )

        }
    }
}