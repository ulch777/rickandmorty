package com.ulch.rickandmorty.ui.character_list.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ulch.rickandmorty.databinding.CharacterItemBinding
import com.ulch.rickandmorty.models.CharacterModel
import com.ulch.rickandmorty.utils.BaseDiffUtilCallback
import com.ulch.rickandmorty.utils.Constants.STATUS_ALIVE
import com.ulch.rickandmorty.utils.Constants.STATUS_DEAD
import com.ulch.rickandmorty.utils.setScaleAnimation


class CharacterAdapter :
    PagingDataAdapter<CharacterModel, CharacterAdapter.CharacterViewHolder>(BaseDiffUtilCallback()) {


    class CharacterViewHolder(val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(characterModel: CharacterModel) {
            Glide.with(binding.characterImage.context)
                .load(characterModel.image)
                .fitCenter()
                .into(binding.characterImage)
            binding.characterName.text = characterModel.name
            binding.characterStatus.text = characterModel.status
            val statusColor = when (characterModel.status) {
                STATUS_ALIVE -> Color.GREEN
                STATUS_DEAD -> Color.RED
                else -> Color.YELLOW
            }
            binding.characterStatus.setTextColor(statusColor)
            binding.executePendingBindings()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            CharacterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val model = getItem(position)
        model?.apply {
            holder.bind(this)
            holder.itemView.setScaleAnimation()
        }
    }
}