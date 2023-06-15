package com.example.dogsapp.repository

import com.example.dogsapp.api.DogsResponse

interface DogsRepository {
    fun getDogsImage(
        onSuccess: (DogsResponse?) -> Unit,
        onFailure: (Throwable) -> Unit
    )
}