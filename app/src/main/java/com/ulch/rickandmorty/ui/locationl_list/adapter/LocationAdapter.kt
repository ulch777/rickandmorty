package com.ulch.rickandmorty.ui.locationl_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ulch.rickandmorty.databinding.LocationItemBinding
import com.ulch.rickandmorty.models.LocationModel
import com.ulch.rickandmorty.utils.BaseDiffUtilCallback
import com.ulch.rickandmorty.utils.setScaleAnimation


class LocationAdapter :
    PagingDataAdapter<LocationModel, LocationAdapter.LocationViewHolder>(BaseDiffUtilCallback()) {


    class LocationViewHolder(val binding: LocationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(model: LocationModel) {
            binding.tvType.text = model.type
            binding.tvName.text = model.name
            binding.executePendingBindings()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            LocationItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }


    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val model = getItem(position)
        model?.apply {
            holder.bind(this)
            holder.itemView.setScaleAnimation()
        }
    }

}