package com.ulch.rickandmorty.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ulch.rickandmorty.utils.setDebounceListener


abstract class BaseAdapter<T, VH : BaseAdapter.BaseViewHolder<T>>(
    open var items: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<VH>() {

    var onItemClick: ((Int) -> Unit)? = null

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (isInPositionsRange(position)) {
            holder.itemView.setDebounceListener {
                onItemClick?.invoke(holder.adapterPosition)
            }
            holder.onBind(items[position], position)
        }
    }

    override fun getItemCount() = items.size



    fun addItem(item: T, position: Int = items.size) {
        items.add(position,item)
        notifyItemInserted(position)
    }
//
    fun addItems(newItems: List<T>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
//
    fun clear(){
        items.clear()
        notifyDataSetChanged()
    }

    fun isInPositionsRange(position: Int) =
        position != RecyclerView.NO_POSITION && position < itemCount

    abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun onBind(item: T, position: Int)
    }
}