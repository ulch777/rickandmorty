package com.ulch.rickandmorty.ui.main_menu.adapter

import android.view.ViewGroup
import com.ulch.rickandmorty.R
import com.ulch.rickandmorty.base.BaseBindingAdapter
import com.ulch.rickandmorty.databinding.MenuItemBinding
import com.ulch.rickandmorty.utils.setScaleAnimation

class MenuAdapter :
    BaseBindingAdapter<String, MenuAdapter.ViewHolder, MenuItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(initBinding(R.layout.menu_item, parent))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        if (isInPositionsRange(position)) {
            holder.onBind(items[holder.adapterPosition], holder.adapterPosition)
            holder.itemView.setScaleAnimation()
        }
    }

    class ViewHolder(binding: MenuItemBinding) :
        BaseBindingViewHolder<String, MenuItemBinding>(binding) {


        override fun onBind(item: String, position: Int) {
            with(binding) {
                itemText.text = item
            }
        }
    }
}
