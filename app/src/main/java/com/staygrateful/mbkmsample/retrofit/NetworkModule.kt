package com.staygrateful.mbkmsample.retrofit

import com.google.gson.GsonBuilder
import com.staygrateful.mbkmsample.RetrofitActivity
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {

    var loggerCallback: ((String) -> Unit)? = null

    fun provideRequestInterceptor(token: String?): Interceptor {
        return Interceptor { chain ->
            try {
                token?.let {
                    val req = chain.request().newBuilder()
                    req.addHeader("Accept", "application/json")
                    req.addHeader("Authorization", "Bearer $token")

                    val requestBuilder = req.build()

                    chain.proceed(requestBuilder)
                } ?: chain.proceed(chain.request())
            } catch (e: Exception) {
                e.printStackTrace()
                chain.proceed(chain.request())
            }
        }
    }

    fun provideOkhttpClient(interceptor: Interceptor): OkHttpClient {
        val networkTimeout: Long = 20
        val logger = HttpLoggingInterceptor.Logger { message ->
            Platform.get().log(message)
            loggerCallback?.invoke(message)
        }

        val httpClientBuilder = OkHttpClient.Builder().apply {
            connectTimeout(networkTimeout, TimeUnit.SECONDS)
            writeTimeout(networkTimeout, TimeUnit.SECONDS)
            readTimeout(networkTimeout, TimeUnit.SECONDS)
            addInterceptor(interceptor)
        }

        httpClientBuilder.apply {
            addInterceptor(HttpLoggingInterceptor(logger).apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        return httpClientBuilder.build()
    }

    fun provideRestClient(okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        builder.client(okHttpClient)
            .baseUrl(BASE_URL)
            //.addCallAdapterFactory(CoroutineCallAdapterFactory())
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
        return builder.build()
    }

    fun provideApiServices(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    fun Builder(token: String? = null): Api {
        return provideApiServices(
            provideRestClient(
                provideOkhttpClient(
                    provideRequestInterceptor(
                        token
                    )
                )
            )
        )
    }

    const val BASE_URL = "https://api.themoviedb.org" //https://be.dharma.dcs.stechoq.com
}