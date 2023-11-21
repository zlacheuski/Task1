package com.example.task1.tools.extensions

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.task1.R

private const val RADIUS = 30f
private const val WIDTH = 5f

fun Context.createCircularProgressBar(): CircularProgressDrawable {
    return CircularProgressDrawable(this).apply {
        setColorSchemeColors(R.color.dark_blue)
        centerRadius = RADIUS
        strokeWidth = WIDTH
        start()
    }
}

