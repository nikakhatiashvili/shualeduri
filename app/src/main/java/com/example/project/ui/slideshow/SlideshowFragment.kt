package com.example.project.ui.slideshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.databinding.FragmentSlideshowBinding
import com.example.project.ui.BaseFragment

class SlideshowFragment : BaseFragment<FragmentSlideshowBinding, SlideshowViewModel>(FragmentSlideshowBinding::inflate,SlideshowViewModel::class.java) {
    private lateinit var adapter:WeaponAdapter

    override fun init(inflater: LayoutInflater, viewGroup: ViewGroup?) {
        viewModel.load()
        bind()
    }

    private fun bind(){
        adapter = WeaponAdapter()
        binding?.recyclerviewWeapons?.adapter = adapter
        binding?.recyclerviewWeapons?.layoutManager = GridLayoutManager(requireContext(),1)
        viewModel.agentInfo.observe(viewLifecycleOwner){
            adapter.data = it
        }
    }
}