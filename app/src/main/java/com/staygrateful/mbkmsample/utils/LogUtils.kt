package com.staygrateful.mbkmsample.utils

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

object LogUtils {

    fun logCatOutput(coroutineContext: CoroutineContext) = liveData(coroutineContext) {
        withContext(Dispatchers.IO) {
            emit("OkHttpClient")
            Runtime.getRuntime().exec("logcat -c")
            Runtime.getRuntime().exec("logcat")
                .inputStream
                .bufferedReader()
                .useLines { lines ->
                    lines.forEach { line ->
                        println("LINE -> $line")
                        emit(line)
                    }
                }
        }
    }
}