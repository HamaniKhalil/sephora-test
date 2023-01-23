package com.sephoratest.app.products.list

object LikeIconStyleFactory {

    fun fromState(liked: Boolean) = when(liked) {
        true -> LikeIconStyle.LikedStyle
        else -> LikeIconStyle.UnlikedStyle
    }
}