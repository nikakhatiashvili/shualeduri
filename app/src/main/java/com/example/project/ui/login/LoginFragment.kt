package com.example.project.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.project.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginFragment :Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var email:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKeys") { requestKey, bundle ->
            var  email = bundle.getString("bundleKeys")!!
            binding.usernameEditTxt.setText(email)
        }
        setFragmentResultListener("passKeys") { requestKey, bundle ->
            val pass = bundle.getString("passKeys")
            binding.passwordEditTxt.setText(pass.toString())
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        bind()
        return view
    }

    private fun bind() {
        binding.registerTextview.setOnClickListener{
            findNavController().navigate(com.example.project.R.id.action_loginFragment_to_registerFragment)
        }
        binding.loginBtn.setOnClickListener {
            when{
                TextUtils.isEmpty(binding.usernameEditTxt.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(activity,"please enter email.", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.passwordEditTxt.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(activity,"please enter password.", Toast.LENGTH_SHORT).show()
                }
                else -> {
                     email = binding.usernameEditTxt.text.toString().trim{ it <= ' '}
                    val password:String = binding.passwordEditTxt.text.toString().trim{ it <= ' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener{ task ->
                            if(task.isSuccessful){
                                Toast.makeText(activity,"you are logged in successfully.", Toast.LENGTH_SHORT).show()
                                findNavController().navigate(com.example.project.R.id.action_loginFragment_to_nav_gallery)
                            }else{
                                Toast.makeText(activity,task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
        }
    }

}
