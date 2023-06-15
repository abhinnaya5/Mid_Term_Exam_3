package com.example.dogsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogsapp.api.DogsResponse
import com.example.dogsapp.repository.DogsRepository
import com.example.dogsapp.repository.DogsRepositoryImpl

class MainViewModel: ViewModel() {
    private val dogsRepository: DogsRepository

    init {
        dogsRepository = DogsRepositoryImpl()
    }

    private val _dogs = MutableLiveData<DogsResponse>()
    val dogs : LiveData<DogsResponse?> = _dogs

    fun getDogsImage() {
        dogsRepository.getDogsImage(onSuccess = {
            _dogs.value = it
        }, onFailure = {
            _dogs.value = null
        })
    }
}