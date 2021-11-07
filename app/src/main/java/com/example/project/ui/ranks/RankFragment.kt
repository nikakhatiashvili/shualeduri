package com.example.project.ui.ranks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.databinding.FragmentRankBinding
import com.example.project.databinding.FragmentSlideshowBinding
import com.example.project.model.ranks.Player
import com.example.project.ui.BaseFragment
import com.example.project.ui.slideshow.SlideshowViewModel
import com.example.project.ui.slideshow.WeaponAdapter


class RankFragment : BaseFragment<FragmentRankBinding, RankViewModel>(FragmentRankBinding::inflate, RankViewModel::class.java) {

        private lateinit var adapter: RankAdapter
        private lateinit var data:MutableList<Player>
        override fun init(inflater: LayoutInflater, viewGroup: ViewGroup?) {
            viewModel.load()
            bind()
        }

        private fun bind(){
            data = mutableListOf()
            adapter = RankAdapter(data)
            viewModel.rankInfo.observe(viewLifecycleOwner){
                data = it as MutableList<Player>
//                adapter.data = it as MutableList<Player>
            }

            binding?.recyclerview?.adapter = adapter
            binding?.recyclerview?.layoutManager = GridLayoutManager(requireContext(),1)
            viewModel.rankInfo.observe(viewLifecycleOwner){
                adapter.data = it as MutableList<Player>
            }
            binding?.countrySearch?.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    adapter.filter(query!!)
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    adapter.filter(newText)
                    return true
                }
            })
        }
    }
