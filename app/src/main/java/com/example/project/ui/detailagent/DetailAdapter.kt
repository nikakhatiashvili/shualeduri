package com.example.project.ui.detailagent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.callback.ClickListener
import com.example.project.databinding.AgentItemBinding
import com.example.project.databinding.DetailAgentBinding
import com.example.project.databinding.RoleItemBinding
import com.example.project.model.agents.Ability
import com.example.project.model.agents.Data
import com.example.project.model.agents.Media
import com.example.project.model.agents.Role

class DetailAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var data:List<Ability> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  AgentViewHolder(DetailAgentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as AgentViewHolder
        holder.bind()
    }

    override fun getItemCount()=data.size

    inner class AgentViewHolder(private val binding: DetailAgentBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var currentData: Ability
        fun bind(){
            currentData = data[adapterPosition]
            binding.apply {
                characterTxt.text = currentData.displayName
                description.text = currentData.description
                Glide.with(itemView.context).load(currentData.displayIcon).into(imgCover)
            }
        }
    }

}