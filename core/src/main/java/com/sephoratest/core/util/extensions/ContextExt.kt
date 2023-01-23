package com.sephoratest.core.util.extensions

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast
        .makeText(
            this,
            text,
            duration
        )
        .show()

fun Context.toast(@StringRes text: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast
        .makeText(
            this,
            getString(text),
            duration
        )
        .show()