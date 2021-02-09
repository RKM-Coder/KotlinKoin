package com.rkm.moviesdemokotlin.rtllabs.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rkm.moviesdemokotlin.rtllabs.data.api.ApiHelper
import com.rkm.moviesdemokotlin.rtllabs.data.repository.MainRepository
import com.rkm.moviesdemokotlin.rtllabs.ui.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}