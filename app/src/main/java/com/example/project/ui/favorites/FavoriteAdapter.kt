package com.example.project.ui.favorites

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.databinding.FragmentFavoriteItemBinding
import com.example.project.databinding.MapItemBinding
import com.example.project.model.maps.MapData
import com.example.project.model.saved.SavedSprays

class FavoriteAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var data:List<SavedSprays> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  AgentViewHolder(FragmentFavoriteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as AgentViewHolder
        holder.bind()
    }

    override fun getItemCount()=data.size

    inner class AgentViewHolder(private val binding: FragmentFavoriteItemBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var currentData: SavedSprays
        fun bind(){
            currentData = data[adapterPosition]
            binding.apply {
                d("sadsagasfas",currentData.name + currentData.photo)
                binding.characterTxt.text = currentData.photo
                Glide.with(itemView.context).load(currentData.name).into(binding.imgCover)
            }
        }
    }
}