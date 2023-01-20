package com.ulch.rickandmorty.ui.locationl_list

import androidx.paging.PagingData
import com.ulch.rickandmorty.base.BaseViewModel
import com.ulch.rickandmorty.entities.responses.toLocationModel
import com.ulch.rickandmorty.models.LocationModel
import com.ulch.rickandmorty.repository.Repository
import kotlinx.coroutines.flow.Flow

class LocationListViewModel(private val repository: Repository) : BaseViewModel() {
    suspend fun getListData(): Flow<PagingData<LocationModel>> {
        return repository.getAllLocations(
        ).toLocationModel()
    }
}