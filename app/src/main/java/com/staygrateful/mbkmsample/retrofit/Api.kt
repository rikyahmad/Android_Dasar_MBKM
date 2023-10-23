package com.staygrateful.mbkmsample.retrofit

import com.staygrateful.mbkmsample.LoginRequest
import com.staygrateful.mbkmsample.LoginResponse
import com.staygrateful.mbkmsample.retrofit.model.ResultMovie
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("/3/movie/upcoming?api_key=1fcf815abf04f454d44c9c56df60de5d&language=en-US&page=1")
    fun getMovieList(): Call<ResultMovie?>?

    //https://be.dharma.dcs.stechoq.com/api/login
    @POST("/api/login")
    fun postLogin(
        @Body request: LoginRequest
    ): Call<LoginResponse?>?
}