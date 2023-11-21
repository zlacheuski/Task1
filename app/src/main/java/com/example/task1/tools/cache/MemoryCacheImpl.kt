package com.example.task1.tools.cache

import android.util.LruCache

private const val MEMORY_DIVIDER = 8
private const val BYTES_DIVIDER = 1024

class MemoryCacheImpl {

    private val maxMemory = (Runtime.getRuntime().maxMemory() / BYTES_DIVIDER).toInt()
    private val cacheSize = maxMemory / MEMORY_DIVIDER
    private val memoryCache: LruCache<String, String> =
        object : LruCache<String, String>(cacheSize) {
            override fun sizeOf(key: String?, bitmap: String): Int {
                return bitmap.length / BYTES_DIVIDER
            }
        }

    companion object {
        private var instance: MemoryCacheImpl? = null

        fun getInstance(): MemoryCacheImpl {
            if (instance == null) {
                instance = MemoryCacheImpl()
            }
            return instance as MemoryCacheImpl
        }
    }

//    fun addBitmapToMemoryCache(key: String, bitmap: Bitmap) {
//        if (getBitmapFromMemoryCache(key) == null) {
//            memoryCache.put(key, bitmap)
//        }
//    }

//    fun getBitmapFromMemoryCache(key: String): Bitmap? {
//        return memoryCache.get(key)
//    }
}