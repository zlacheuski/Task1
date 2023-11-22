package com.example.task1.tools.cache

import android.graphics.Bitmap

interface DiskCache {

    fun put(key: String, bitmap: Bitmap)
    fun getBitmap(key: String): Bitmap?
}