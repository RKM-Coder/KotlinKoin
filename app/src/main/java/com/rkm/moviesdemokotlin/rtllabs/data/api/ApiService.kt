package com.rkm.moviesdemokotlin.rtllabs.data.api

import com.rkm.moviesdemokotlin.BuildConfig

import com.rkm.moviesdemokotlin.rtllabs.data.model.MoviesResponse
import com.rkm.moviesdemokotlin.rtllabs.data.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): MoviesResponse
}