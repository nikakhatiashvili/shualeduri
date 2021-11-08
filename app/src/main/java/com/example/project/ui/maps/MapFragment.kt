package com.example.project.ui.maps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.databinding.FragmentMapBinding
import com.example.project.ui.BaseFragment

class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>(FragmentMapBinding::inflate, MapViewModel::class.java) {
    private lateinit var adapter: MapAdapter

    override fun init(inflater: LayoutInflater, viewGroup: ViewGroup?) {
        viewModel.load()
        bind()
    }

    private fun bind(){
        adapter = MapAdapter()
        binding?.recyclerview?.adapter = adapter
        binding?.recyclerview?.layoutManager = GridLayoutManager(requireContext(),1)
        viewModel.agentInfo.observe(viewLifecycleOwner){
            adapter.data = it
        }
    }
}