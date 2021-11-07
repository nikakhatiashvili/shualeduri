package com.example.project.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.project.R
import com.example.project.databinding.FragmentProfileBinding
import com.example.project.databinding.FragmentSprayBinding
import com.example.project.room.user.UserViewModel
import com.example.project.room.user.UserViewModelFactory
import com.example.project.ui.spray.SprayViewModel
import com.example.project.ui.spray.WordViewModelFactory


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        bind()
        return binding.root
    }
    private fun bind(){
        val application = requireNotNull(this.activity).application
        val ViewModelFactory = UserViewModelFactory(application)
        viewModel = ViewModelProvider(this,ViewModelFactory)[UserViewModel::class.java]
    }
}