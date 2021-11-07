package com.example.project.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.callback.ClickListener
import com.example.project.databinding.AgentItemBinding
import com.example.project.model.agents.Data

class GalleryAdapter(private val clickListener: ClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var data:List<Data> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  AgentViewHolder(AgentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as AgentViewHolder
        holder.bind()
    }

    override fun getItemCount()=data.size

    inner class AgentViewHolder(private val binding: AgentItemBinding): RecyclerView.ViewHolder(binding.root),
        View.OnClickListener{
        private lateinit var currentData:Data
        fun bind(){
            currentData = data[adapterPosition]
            binding.imgCover.setOnClickListener(this)
            binding.apply {
                currentData.abilities
                characterTxt.text = currentData.displayName
                description.text = currentData.description
                Glide.with(itemView.context).load(currentData.displayIcon).into(imgCover)
                Glide.with(itemView.context).load(currentData.role?.displayIcon).into(roleIcon)
                roleName.text = currentData.role?.displayName
            }
        }

        override fun onClick(p0: View?) {
           clickListener.onClick(currentData.abilities!!)
        }
    }
}