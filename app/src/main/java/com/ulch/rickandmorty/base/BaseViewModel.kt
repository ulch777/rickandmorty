package com.ulch.rickandmorty.base

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val supervisorJob = SupervisorJob()

    override val coroutineContext =
        Dispatchers.Main.immediate + supervisorJob + CoroutineExceptionHandler { _, e -> onError(e) }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancelChildren()
    }

    open fun onError(exception: Throwable) {
        Log.e("ERROR", "${exception.printStackTrace()}")
    }
}