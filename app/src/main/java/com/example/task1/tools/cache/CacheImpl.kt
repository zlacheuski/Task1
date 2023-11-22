package com.example.task1.tools.cache

import android.graphics.Bitmap
import android.util.LruCache
import com.example.task1.tools.Constants.BYTES_DIVIDER
import com.example.task1.tools.extensions.getBitmapSize
import javax.inject.Inject

class CacheImpl @Inject constructor(private var diskCache: DiskCache) : Cache {

    private val maxMemory = (Runtime.getRuntime().maxMemory() / BYTES_DIVIDER).toInt()
    private val cacheSize = maxMemory / BYTES_DIVIDER
    private val memoryCache: LruCache<String, Bitmap> =
        object : LruCache<String, Bitmap>(cacheSize) {
            override fun sizeOf(key: String, bitmap: Bitmap): Int {
                return bitmap.byteCount / BYTES_DIVIDER
            }
        }

    override fun put(key: String, bitmap: Bitmap) {
        if(get(key)==null){
            if (canCache(bitmap)) {
                memoryCache.put(key, bitmap)
            } else {
                diskCache.put(key, bitmap)
            }
        }
    }

    override fun get(key: String): Bitmap? {
        return memoryCache.get(key) ?: diskCache.getBitmap(key)
    }

    private fun canCache(bitmap: Bitmap) = bitmap.getBitmapSize() + memoryCache.size() <= cacheSize
}