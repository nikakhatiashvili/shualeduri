package com.example.project.ui.spray

import android.content.Context
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.callback.ClickListenerForSave
import com.example.project.databinding.AgentItemBinding
import com.example.project.databinding.SprayItemBinding
import com.example.project.model.sprays.SpraysData
import okhttp3.HttpUrl.Companion.toHttpUrl
import kotlin.coroutines.coroutineContext

class SprayAdapter(private val clickListener: ClickListenerForSave): RecyclerView.Adapter<SprayAdapter.AgentViewHolder>(){

    var data:List<SpraysData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SprayAdapter.AgentViewHolder {
        return  AgentViewHolder(SprayItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SprayAdapter.AgentViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()=data.size

    inner class AgentViewHolder(private val binding: SprayItemBinding): RecyclerView.ViewHolder(binding.root),
        View.OnClickListener{
        private lateinit var currentData: SpraysData
        fun bind(){
            currentData = data[adapterPosition]
            binding.apply {
                saveBtn.setOnClickListener(this@AgentViewHolder)
                binding.characterTxt.text = currentData.displayName
                Glide.with(itemView.context).load(currentData.fullTransparentIcon).into(binding.imgCover)
            }
        }
        override fun onClick(p0: View?) {
                d("sdasdas",currentData.fullTransparentIcon.toString())
                if (currentData.fullTransparentIcon.toString() != "null"){
                val image = currentData.fullTransparentIcon.toString()
                image.toHttpUrl()
                clickListener.onClick(currentData.displayName!!,image,binding.saveBtn)
            }
        }
    }
}


