package com.example.project.ui.home

import android.os.Bundle
import android.os.UserManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import com.example.project.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private val viewModel:HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        bind()
        return root
    }
    private fun bind(){
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}