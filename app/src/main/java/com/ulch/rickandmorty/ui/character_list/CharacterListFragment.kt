package com.ulch.rickandmorty.ui.character_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ulch.rickandmorty.R
import com.ulch.rickandmorty.base.BaseFragment
import com.ulch.rickandmorty.databinding.FragmentCharacterListBinding
import com.ulch.rickandmorty.ui.character_list.adapter.CharacterAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment: BaseFragment<FragmentCharacterListBinding>() {
    override val layoutId = R.layout.fragment_character_list
    private lateinit var adapter: CharacterAdapter

    private val viewModel: CharacterListViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        getListData()
    }
    private fun getListData() {
        lifecycleScope.launch {
            viewModel.getListData().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun setupAdapter() {
        adapter = CharacterAdapter()
        binding.rvCharacterList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCharacterList.adapter = adapter
    }
}