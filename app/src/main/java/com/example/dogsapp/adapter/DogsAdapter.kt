package com.example.dogsapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogsapp.api.DogsResponse
import com.example.dogsapp.databinding.ItemDogsBinding

class DogsAdapter(private val listDogs: ArrayList<DogsResponse>): RecyclerView.Adapter<DogsAdapter.ViewHolder>() {
    class ViewHolder(binding: ItemDogsBinding): RecyclerView.ViewHolder(binding.root) {
        val dogPlaceholder = binding.ivDog
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDogsBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("Adapter", listDogs[position].message)
        Glide.with(holder.itemView)
            .load(listDogs[position].message)
            .into(holder.dogPlaceholder)
    }

    override fun getItemCount(): Int = listDogs.size

}