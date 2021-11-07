package com.example.project.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.project.R
import com.example.project.databinding.FragmentProfileBinding
import com.example.project.datastore.UserManager
import kotlinx.coroutines.DelicateCoroutinesApi
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
        userManager = UserManager(requireContext())
        checker(userManager)
        binding.logoutImageview.setOnClickListener{
        }

    }
    private fun checker(userManager: UserManager){
        viewLifecycleOwner.lifecycleScope.launch {
            userManager.getFromDataStore().observe(viewLifecycleOwner, Observer {
                binding.usernameTextviewForProfile.text = it.email
            })

        }
    }

}