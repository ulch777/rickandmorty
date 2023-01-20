package com.ulch.rickandmorty.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingAdapter<T, VH : BaseBindingAdapter.BaseBindingViewHolder<T, V>, V : ViewDataBinding>
    : BaseAdapter<T, VH>() {
    fun <V : ViewDataBinding> initBinding(
        @LayoutRes
        resId: Int,
        parent: ViewGroup,
        attachToParent: Boolean = false
    ): V =
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), resId, parent, attachToParent)

    abstract class BaseBindingViewHolder<T, V : ViewDataBinding>(open val binding: V) :
        BaseAdapter.BaseViewHolder<T>(binding.root)
}