package com.example.project.ui.detailagent

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.project.databinding.DetailAgentBinding
import com.example.project.databinding.FragmentDetailBinding
import com.example.project.model.agents.Ability
import com.example.project.model.agents.Role

class DetailAgentFragment: Fragment() {
    private var binding: FragmentDetailBinding? = null
    private lateinit var adapter:DetailAdapter
    private lateinit var data:List<Ability>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = arguments?.getParcelableArrayList<Ability>("ability")!!
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null){
            binding = FragmentDetailBinding.inflate(inflater,container,false)
        }
        bind()
        return binding?.root
    }
    private fun bind(){
//        setFragmentResultListener("requestKey") { requestKey, bundle ->
//           val data = bundle.getParcelable("bundleKey")
//        }

//        val data = arguments?.getParcelableArrayList<Ability>("ability")
        d("sdadasda","$data")
        adapter = DetailAdapter()
        binding?.recyclerview?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerview?.adapter = adapter
        adapter.data = data

    }
}