package com.example.task1.tools.cache

import android.graphics.Bitmap


interface MemoryCache {

    fun put(bitmap: Bitmap)
    fun get(key: String): Bitmap?
}