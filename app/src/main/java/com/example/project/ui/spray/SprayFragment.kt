package com.example.project.ui.spray

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.callback.ClickListenerForSave
import com.example.project.databinding.FragmentSprayBinding
import com.example.project.model.saved.SavedSprays

class SprayFragment : Fragment() {
    private lateinit var adapter: SprayAdapter
    private var _binding: FragmentSprayBinding? = null
    private val binding get() = _binding!!
    private var counter:Int = 1
    private lateinit var mUserViewModel: SprayViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSprayBinding.inflate(inflater,container,false)
        val application = requireNotNull(this.activity).application
        val ViewModelFactory = WordViewModelFactory(application)
        mUserViewModel = ViewModelProvider(this,ViewModelFactory)[SprayViewModel::class.java]
        init()
        return binding.root
    }
     fun init() {
         mUserViewModel.load()
        bind()
    }

    private fun bind(){
        adapter = SprayAdapter(object :ClickListenerForSave{
            override fun onClick(data: String,image:String,imgbtn:ImageButton) {
                imgbtn.setImageResource(R.drawable.ic_heart_red_svgrepo_com__1_)
                val info = SavedSprays(data,image)
                d("counter",counter.toString())
                counter = counter + 1
                mUserViewModel.addSpray(info)

            }
        })
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(),1)
        mUserViewModel.sprayInfo.observe(viewLifecycleOwner){
            adapter.data = it
        }
    }
}