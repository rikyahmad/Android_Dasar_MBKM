package com.staygrateful.mbkmsample.extension

import android.content.res.Resources
import android.util.TypedValue

val Number.dp: Float
    get() = try {
        val metrics = Resources.getSystem().displayMetrics
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            metrics
        )
    } catch (e: Exception) {
        0f
    }

val Number.dpInt: Int
    get() = this.dp.toInt()

val Number.px: Float
    get() = try {
        val metrics = Resources.getSystem().displayMetrics
        this.toInt() / metrics.density
    } catch (e: Exception) {
        0f
    }

val screenHeight: Int
    get() = try {
        val metrics = Resources.getSystem().displayMetrics
        metrics.heightPixels
    } catch (e: Exception) {
        0
    }

val screenWidth: Int
    get() = try {
        val metrics = Resources.getSystem().displayMetrics
        metrics.widthPixels
    } catch (e: Exception) {
        0
    }