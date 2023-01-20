package com.ulch.rickandmorty.ui.episode_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ulch.rickandmorty.R
import com.ulch.rickandmorty.base.BaseFragment
import com.ulch.rickandmorty.databinding.FragmentEpisodeListBinding
import com.ulch.rickandmorty.ui.episode_list.adapter.EpisodeAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeListFragment: BaseFragment<FragmentEpisodeListBinding>() {
    override val layoutId = R.layout.fragment_episode_list
    private lateinit var adapter: EpisodeAdapter

    private val viewModel: EpisodeListViewModel by viewModel()
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
        adapter = EpisodeAdapter()
        binding.rvEpisodeList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvEpisodeList.adapter = adapter
    }
}