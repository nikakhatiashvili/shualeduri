package com.example.project.ui.favorites

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.databinding.FragmentFavoriteBinding
import com.example.project.ui.maps.MapAdapter
import com.example.project.ui.spray.SprayViewModel
import com.example.project.ui.spray.WordViewModelFactory


class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: FavoriteAdapter
    private lateinit var  viewmodel:SprayViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        val application = requireNotNull(this.activity).application
        val ViewModelFactory = WordViewModelFactory(application)
        viewmodel = ViewModelProvider(this,ViewModelFactory)[SprayViewModel::class.java]
        bind()
        return binding.root
    }

    private fun bind(){
        adapter = FavoriteAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(),1)
        viewmodel.readAllData.observe(viewLifecycleOwner){
            d("sadasdadsada",it.toString())
            adapter.data = it
        }
        binding.deleteBtn.setOnClickListener{
            viewmodel.delete()
        }
    }
}