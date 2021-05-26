package com.mks.mvvm.model

data class Model(
    val page : Int,
    val per_page : Int,
    val total : Int,
    val data : List<User>,
    val support : Support
)
