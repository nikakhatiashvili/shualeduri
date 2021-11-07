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
        override fun init(inflater: LayoutInflater, viewGroup: ViewGroup?) {
            viewModel.load()
            bind()
        }

        private fun bind(){

            adapter = RankAdapter()
            binding?.recyclerview?.adapter = adapter
            binding?.recyclerview?.layoutManager = GridLayoutManager(requireContext(),1)
            viewModel.rankInfo.observe(viewLifecycleOwner){
                adapter.data = it as MutableList<Player>
            }
        }
    }
