package com.example.project.ui.ranks

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.databinding.FragmentRankItemBinding
import com.example.project.model.ranks.Player

const val BASE_PHOTO = "https://media.valorant-api.com/competitivetiers/e4e9a692-288f-63ca-7835-16fbf6234fda/24/smallicon.png"
const val BASE_THEME = "https://media.valorant-api.com/playercards/33c1f011-4eca-068c-9751-f68c788b2eee/displayicon.png"
class RankAdapter(var data:List<Player>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
//
//        var data:MutableList<Player> = mutableListOf()
//            set(value) {
//                field = value
//                notifyDataSetChanged()
//            }
    var nikaData = ArrayList<Player>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return  AgentViewHolder(FragmentRankItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder as AgentViewHolder
            holder.bind()
        }


    fun filter(text: String) {
        var text = text
        nikaData.clear()
        if (text.isEmpty()) {
            nikaData.addAll(data)
        } else {
            text = text.toLowerCase()
            for (item in data) {
                if (item.gameName.isNullOrEmpty()){

                }else{
                if (item.gameName?.toLowerCase()?.contains(text)!!) {
                    d("sdasdasd",item.gameName.toString())
                    nikaData.add(item)
                    }
                }
            }
        }
        notifyDataSetChanged()
    }

        override fun getItemCount()=data.size

        inner class AgentViewHolder(private val binding: FragmentRankItemBinding): RecyclerView.ViewHolder(binding.root){
            private lateinit var currentData: Player
            fun bind(){
                nikaData.addAll(data)
                currentData = nikaData[adapterPosition]
                binding.apply {
                    characterTxt.text = currentData.leaderboardRank.toString()
                    gamename.text = currentData.gameName.toString()
                    gamesWon.text = currentData.rankedRating.toString()
                    Glide.with(itemView.context).load(BASE_PHOTO).into(agentTheme)
                    Glide.with(itemView.context).load(BASE_THEME).into(imgCover)

                }
            }

        }
    }
