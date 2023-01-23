package com.sephoratest.app.products.list

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sephoratest.R

sealed class LikeIconStyle(
    @DrawableRes
    val icon: Int,
    @StringRes
    val contentDescription: Int
) {

    object LikedStyle : LikeIconStyle(
        icon = R.drawable.ic_like_selected,
        contentDescription = R.string.accessibility_liked
    )

    object UnlikedStyle : LikeIconStyle(
        icon = R.drawable.ic_like_unselected,
        contentDescription = R.string.accessibility_unliked
    )

}