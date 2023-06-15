package com.example.dogsapp.repository

import com.example.dogsapp.api.ApiConfig
import com.example.dogsapp.api.DogsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogsRepositoryImpl: DogsRepository {
    override fun getDogsImage(onSuccess: (DogsResponse?) -> Unit, onFailure: (Throwable) -> Unit) {
        ApiConfig.ApiService.getDogsImage().enqueue(object: Callback<DogsResponse> {
            override fun onResponse(call: Call<DogsResponse>, response: Response<DogsResponse>) {
                if(response.isSuccessful) {
                    val body = response.body()
                    onSuccess(body)
                } else {
                    onFailure(Exception("Network error"))
                }
            }

            override fun onFailure(call: Call<DogsResponse>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}