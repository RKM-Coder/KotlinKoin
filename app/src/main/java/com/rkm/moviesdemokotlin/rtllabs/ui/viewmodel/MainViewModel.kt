package com.rkm.moviesdemokotlin.rtllabs.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rkm.moviesdemokotlin.rtllabs.data.repository.MainRepository
import com.rkm.moviesdemokotlin.rtllabs.util.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
/*We are going to come across some new keywords such as “Coroutines”, “liveData scope”, “Dispatchers” in this ViewModel. */
class MainViewModel(private val mainRepository: MainRepository):ViewModel() {

    fun getUser() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUser()))
        }catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getMOviesList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getMOviesList()))
        }catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}