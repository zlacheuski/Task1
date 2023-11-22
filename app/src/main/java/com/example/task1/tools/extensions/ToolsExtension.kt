package com.example.task1.tools.extensions

import android.graphics.Bitmap
import com.example.task1.tools.Constants


fun Bitmap.getBitmapSize(): Int = this.byteCount / Constants.BYTES_DIVIDER