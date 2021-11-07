package com.example.project.ui.slideshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.databinding.WeaponsItemBinding
import com.example.project.model.weapons.WeaponsData

class WeaponAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var data:List<WeaponsData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  AgentViewHolder(WeaponsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as AgentViewHolder
        holder.bind()
    }

    override fun getItemCount()=data.size

    inner class AgentViewHolder(private val binding: WeaponsItemBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var currentData: WeaponsData
        fun bind(){
            currentData = data[adapterPosition]
            binding.apply {
                binding.characterTxt.text = currentData.displayName
                val category = currentData.category?.removePrefix("EEquippableCategory::")
                binding.description.text = category
                Glide.with(itemView.context).load(currentData.displayIcon).into(binding.imgCover)
            }
        }
    }
}