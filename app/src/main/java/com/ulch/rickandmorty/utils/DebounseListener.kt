package com.ulch.rickandmorty.utils

import android.view.View

private var lastClickTime = 0L
fun View.setDebounceListener(interval: Int = 250, listenerBlock: (view: View?) -> Unit) {

    val customListener = View.OnClickListener {
        val currentTime = System.currentTimeMillis()
        try {
            if (currentTime - lastClickTime > interval) {
                lastClickTime = currentTime
                listenerBlock(it)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    this.setOnClickListener(customListener)
}