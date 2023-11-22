package com.example.task1.tools.cache

import android.graphics.Bitmap


interface Cache {

    fun put(key: String, bitmap: Bitmap)
    fun get(key: String): Bitmap?
}