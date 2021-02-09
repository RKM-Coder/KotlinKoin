package com.rkm.moviesdemokotlin.rtllabs.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUser() =apiService.getUsers()
    suspend fun getMoviesList() =apiService.getPopularMovies()
}