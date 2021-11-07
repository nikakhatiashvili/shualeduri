package com.example.project.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.databinding.FragmentGalleryBinding
import com.example.project.databinding.FragmentSlideshowBinding
import com.example.project.ui.BaseFragment
import com.example.project.ui.gallery.GalleryAdapter
import com.example.project.ui.gallery.GalleryViewModel

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