package com.ulch.rickandmorty.entities.responses

data class Info(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
    )