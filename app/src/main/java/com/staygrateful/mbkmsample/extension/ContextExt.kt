package com.staygrateful.mbkmsample.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.app.Service
import android.app.UiModeManager
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.hardware.display.DisplayManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.TypedValue
import android.view.Display
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.lang.Exception

fun Context.drawable(@DrawableRes drawableRes: Int): Drawable? =
    AppCompatResources.getDrawable(this, drawableRes)

fun Context.color(@ColorRes colorRes: Int): Int =
    ContextCompat.getColor(this, colorRes)

fun ContextWrapper?.showToast(
    message: String?,
    post: Boolean = false,
    duration: Int = Toast.LENGTH_SHORT
) {
    this?.baseContext.showToast(message, post, duration)
}

fun Service?.showToast(
    message: String?,
    post: Boolean = false,
    duration: Int = Toast.LENGTH_SHORT
) {
    this?.baseContext.showToast(message, post, duration)
}

fun Application?.showToast(
    message: String?,
    post: Boolean = false,
    duration: Int = Toast.LENGTH_SHORT
) {
    this?.applicationContext.showToast(message, post, duration)
}

fun Fragment?.showToast(
    message: String?,
    post: Boolean = false,
    duration: Int = Toast.LENGTH_SHORT
) {
    this?.context.showToast(message, post, duration)
}

fun Activity?.showToast(
    message: String?,
    post: Boolean = false,
    duration: Int = Toast.LENGTH_SHORT
) {
    this?.applicationContext.showToast(message, post, duration)
}

fun View?.showToast(message: String?, post: Boolean = false, duration: Int = Toast.LENGTH_SHORT) {
    this?.context.showToast(message, post, duration)
}

fun Context?.showToast(
    message: String?,
    post: Boolean = false,
    duration: Int = Toast.LENGTH_SHORT
) {
    if (this != null) {
        if (post) {
            runOnUi {
                Toast.makeText(this, message, duration).show()
            }
            return
        }
        Toast.makeText(this, message, duration).show()
    }
}

fun runOnUi(runnable: Runnable) {
    Handler(Looper.getMainLooper()).post(runnable)
}

fun runOnUi(runnable: Runnable, delayTime: Long) {
    Handler(Looper.getMainLooper()).postDelayed(runnable, delayTime)
}

@ColorInt
fun Context.getColorInt(colorRes: Int): Int {
    return ContextCompat.getColor(this, colorRes)
}

fun <T : Activity> Context?.startActivity(clazz: Class<T>) {
    if (this is Activity) {
        this.startActivity(Intent(this, clazz))
    }
}

@ColorInt
fun Context.colorResources(@ColorRes resId: Int): Int {
    return ContextCompat.getColor(this, resId)
}

@SuppressLint("DiscouragedApi")
fun Context.drawable(resourceName: String): Drawable? {
    try {
        return ContextCompat.getDrawable(
            this, resources.getIdentifier(resourceName, "drawable", packageName)
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}