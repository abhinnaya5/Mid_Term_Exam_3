package com.example.dogsapp.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("random")
    fun getDogsImage(): Call<DogsResponse>
}
