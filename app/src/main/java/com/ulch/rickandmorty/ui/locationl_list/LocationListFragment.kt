package com.ulch.rickandmorty.ui.locationl_list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ulch.rickandmorty.R
import com.ulch.rickandmorty.base.BaseFragment
import com.ulch.rickandmorty.databinding.FragmentLocationListBinding
import com.ulch.rickandmorty.ui.locationl_list.adapter.LocationAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationListFragment: BaseFragment<FragmentLocationListBinding>() {
    override val layoutId = R.layout.fragment_location_list
    private lateinit var adapter: LocationAdapter

    private val viewModel: LocationListViewModel by viewModel()
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
        adapter = LocationAdapter()
        binding.rvLocationList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvLocationList.adapter = adapter
    }
}