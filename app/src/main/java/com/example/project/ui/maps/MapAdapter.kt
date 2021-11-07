package com.example.project.ui.maps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.databinding.AgentItemBinding
import com.example.project.databinding.MapItemBinding
import com.example.project.model.agents.Data
import com.example.project.model.maps.MapData

class MapAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var data:List<MapData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  AgentViewHolder(MapItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as AgentViewHolder
        holder.bind()
    }

    override fun getItemCount()=data.size

    inner class AgentViewHolder(private val binding: MapItemBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var currentData: MapData
        fun bind(){
            currentData = data[adapterPosition]
            binding.apply {
                binding.characterTxt.text = currentData.displayName
                Glide.with(itemView.context).load(currentData.displayIcon).into(binding.imgCover)
                Glide.with(itemView.context).load(currentData.splash).into(binding.imgDisplay)
            }
        }
    }
}