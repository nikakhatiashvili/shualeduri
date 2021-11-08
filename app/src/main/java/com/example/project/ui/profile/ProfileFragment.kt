package com.example.project.ui.profile

import android.os.Bundle
import android.os.UserManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.project.databinding.FragmentProfileBinding
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var userManager: UserManager
    private  var email:String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        bind()
        return binding.root
    }
    private fun bind(){
        binding.logoutImageview.setOnClickListener{
        }

    }
    private fun checker(userManager: UserManager){

    }

}