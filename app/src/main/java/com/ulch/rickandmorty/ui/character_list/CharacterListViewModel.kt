package com.ulch.rickandmorty.ui.character_list

import androidx.paging.PagingData
import com.ulch.rickandmorty.base.BaseViewModel
import com.ulch.rickandmorty.entities.responses.toCharacterModel
import com.ulch.rickandmorty.models.CharacterModel
import com.ulch.rickandmorty.repository.Repository
import kotlinx.coroutines.flow.Flow

class CharacterListViewModel(private val repository: Repository) : BaseViewModel() {
    suspend fun getListData(): Flow<PagingData<CharacterModel>> {
        return repository.getAllCharacters(
        ).toCharacterModel()
    }
}