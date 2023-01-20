package com.ulch.rickandmorty.ui.episode_list.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ulch.rickandmorty.databinding.EpisodeItemBinding
import com.ulch.rickandmorty.models.EpisodeModel
import com.ulch.rickandmorty.utils.BaseDiffUtilCallback
import com.ulch.rickandmorty.utils.Constants
import com.ulch.rickandmorty.utils.setScaleAnimation


class EpisodeAdapter :
    PagingDataAdapter<EpisodeModel, EpisodeAdapter.EpisodeViewHolder>(BaseDiffUtilCallback()) {


    class EpisodeViewHolder(val binding: EpisodeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(model: EpisodeModel) {
            binding.tvEpisode.text = model.episode
            binding.tvName.text = model.name
            binding.tvDate.text = model.airDate
            binding.executePendingBindings()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            EpisodeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val model = getItem(position)
        model?.apply {
            holder.bind(this)
            holder.itemView.setScaleAnimation()
        }
    }

}