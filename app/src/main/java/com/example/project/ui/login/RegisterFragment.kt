package com.example.project.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.project.R
import com.example.project.databinding.FragmentRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        bind()
        return view
    }

    private fun bind() {
        binding.backTextview.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.registerBtn.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.emailEditTxt.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(activity, "please enter username", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(
                    binding.passwordEditTxt.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(activity, "please enter username", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val userName: String = binding.emailEditTxt.text.toString().trim { it <= ' ' }
                    val password: String =
                        binding.passwordEditTxt.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(userName, password)
                        .addOnCompleteListener(OnCompleteListener<AuthResult> { task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                Toast.makeText(
                                    activity,
                                    "you are registered succesfully",
                                    Toast.LENGTH_SHORT
                                ).show()
                                setFragmentResult("requestKeys", bundleOf("bundleKeys" to userName))
                                setFragmentResult("passKeys", bundleOf("passKeys" to password))
                                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                            } else {
                                Toast.makeText(
                                    activity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                }
            }
        }
    }
}