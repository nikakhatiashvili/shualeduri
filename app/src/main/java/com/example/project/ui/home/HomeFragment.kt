package com.example.project.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.project.R
import com.example.project.databinding.FragmentHomeBinding
import com.example.project.datastore.UserManager
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private val viewModel:HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private lateinit var userManager: UserManager
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