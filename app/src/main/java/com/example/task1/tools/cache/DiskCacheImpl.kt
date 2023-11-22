package com.example.task1.tools.cache

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.task1.tools.extensions.getBitmapSize
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class DiskCacheImpl @Inject constructor(@ApplicationContext val context: Context) : DiskCache {

    private val DISK_CACHE_SIZE = 1024 * 1024 * 300
    private val cacheDir: File = context.cacheDir

    override fun put(key: String, bitmap: Bitmap) {
        val file = File(getFileAbsolutePath(key))
        if (!file.exists()) {
            if (!canCache(bitmap)) {
                removeFewFiles()
            }
            writeBitmapToFile(key, bitmap)
        }
    }

    override fun getBitmap(key: String): Bitmap? {
        val file = File(getFileAbsolutePath(key))
        return when {
            file.exists() -> {
                BitmapFactory.decodeFile(file.absolutePath)
            }
            else -> null
        }
    }

    private fun getFileAbsolutePath(key: String): String {
        return cacheDir.absolutePath + File.separator + key
    }

    private fun writeBitmapToFile(key: String, bitmap: Bitmap) {
        val folder = File(cacheDir.absolutePath)
        val destination = File(folder, key)
        destination.createNewFile()
        val bos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos)
        val bitmapData = bos.toByteArray()

        FileOutputStream(destination).apply {
            write(bitmapData)
            flush()
            close()
        }
    }

    private fun removeFewFiles() {

        cacheDir.listFiles()?.sortedBy { it.lastModified() }?.let { files ->

            var deletedFilesSize = 0L
            val deletedFilesSizeMax = (DISK_CACHE_SIZE / 8).toLong()

            files.forEach { file ->
                val fileSize = file.length()

                if (file.delete()) {
                    deletedFilesSize += fileSize

                    if (deletedFilesSize >= deletedFilesSizeMax) {
                        return@forEach
                    }
                }
            }
        }
    }

    private fun canCache(bitmap: Bitmap) =
        bitmap.getBitmapSize() + getCacheSize() <= DISK_CACHE_SIZE

    private fun getCacheSize(): Long {
        return cacheDir.listFiles()?.sumOf {
            it.length()
        } ?: 0L
    }
}