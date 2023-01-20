package com.ulch.rickandmorty.ui.episode_list

import androidx.paging.PagingData
import com.ulch.rickandmorty.base.BaseViewModel
import com.ulch.rickandmorty.entities.responses.toEpisodeModel
import com.ulch.rickandmorty.models.EpisodeModel
import com.ulch.rickandmorty.repository.Repository
import kotlinx.coroutines.flow.Flow

class EpisodeListViewModel(private val repository: Repository) : BaseViewModel() {
    suspend fun getListData(): Flow<PagingData<EpisodeModel>> {
        return repository.getAllEpisodes(
        ).toEpisodeModel()
    }
}