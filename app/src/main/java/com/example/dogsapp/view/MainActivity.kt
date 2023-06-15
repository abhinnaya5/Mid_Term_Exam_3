package com.example.dogsapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogsapp.adapter.DogsAdapter
import com.example.dogsapp.api.DogsResponse
import com.example.dogsapp.databinding.ActivityMainBinding
import com.example.dogsapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
//    private lateinit var listDogs: ArrayList<DogsResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.rvDogs.layoutManager = LinearLayoutManager(this)

        val listDogs = ArrayList<DogsResponse>()
        for(i in 1 ..10) {
            viewModel.getDogsImage()
            viewModel.dogs.observe(this) {
                if(it != null) {
                    val dogs = DogsResponse(
                        message = it.message,
                        status = it.status
                    )
                    listDogs.add(dogs)
                    val adapter = DogsAdapter(listDogs)
                    binding.rvDogs.adapter = adapter
                }
            }
        }
    }
}