package com.example.project.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.project.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.project.databinding.FragmentLoginBinding
import com.example.project.datastore.UserManager
import com.example.project.model.User
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch


class LoginFragment :Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var email:String
    private lateinit var userManager:UserManager
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
        listener()
        bind()
        return view
    }

    private fun listener(){
        userManager = UserManager(requireContext())
        bind()
       val actionBar = activity?.actionBar
        actionBar?.hide()
        activity?.actionBar?.hide()
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
                                val user = User(email)
                                observer(userManager,user)
                                findNavController().navigate(com.example.project.R.id.action_loginFragment_to_nav_gallery)
                            }else{
                                Toast.makeText(activity,task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
        }
    }
    private fun observer(userManager: UserManager,user:User){
        viewLifecycleOwner.lifecycleScope.launch {
            userManager.saveToDataStore(user)
        }
    }
}
