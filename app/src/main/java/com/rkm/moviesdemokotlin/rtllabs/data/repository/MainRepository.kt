package com.rkm.moviesdemokotlin.rtllabs.data.repository

import com.rkm.moviesdemokotlin.rtllabs.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUser() =apiHelper.getUser();
    suspend fun getMOviesList() =apiHelper.getMoviesList();
}