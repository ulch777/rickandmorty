package com.ulch.rickandmorty.ui.main_menu


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ulch.rickandmorty.R
import com.ulch.rickandmorty.base.BaseFragment
import com.ulch.rickandmorty.databinding.FragmentMainBinding
import com.ulch.rickandmorty.ui.main_menu.adapter.MenuAdapter

class MainMenuFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutId = R.layout.fragment_main
    private lateinit var adapter: MenuAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupListeners()
    }

    private fun setupListeners() {
        adapter.onItemClick = { position ->
            when (position) {
                0 -> findNavController().navigate(
                    MainMenuFragmentDirections.toCharacterListFragment()
                )
                1 -> findNavController().navigate(
                    MainMenuFragmentDirections.toLocationFragment()
                )
                2 -> findNavController().navigate(
                    MainMenuFragmentDirections.toEpisodeFragment()
                )
            }
        }
    }

    private fun setupAdapter() {
        adapter = MenuAdapter()
        binding.menuRv.adapter = adapter
        adapter.addItems(getNames<Title>())
    }
    private inline fun <reified T : Enum<T>> getNames() = enumValues<T>().map { it.name }

}





