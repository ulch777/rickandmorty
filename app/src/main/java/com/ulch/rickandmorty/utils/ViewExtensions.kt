package com.ulch.rickandmorty.utils

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation

fun View.setScaleAnimation() {
    val anim = ScaleAnimation(
        0.7f,
        1.0f,
        0.7f,
        1.0f,
        Animation.RELATIVE_TO_SELF,
        0.5f,
        Animation.RELATIVE_TO_SELF,
        0.5f
    )
    anim.duration = Constants.FADE_DURATION.toLong()
    this.startAnimation(anim)
}

