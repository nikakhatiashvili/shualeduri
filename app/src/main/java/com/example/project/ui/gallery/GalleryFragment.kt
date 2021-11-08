package com.example.project.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.callback.ClickListener
import com.example.project.databinding.FragmentGalleryBinding
import com.example.project.model.agents.Ability
import com.example.project.ui.BaseFragment

class GalleryFragment : BaseFragment<FragmentGalleryBinding, GalleryViewModel>(FragmentGalleryBinding::inflate,GalleryViewModel::class.java) {
    private lateinit var adapter:GalleryAdapter

    override fun init(inflater: LayoutInflater, viewGroup: ViewGroup?) {
        viewModel.load()
        bind()
    }

    private fun bind(){

        adapter = GalleryAdapter(object :ClickListener{
            override fun onClick(ability: List<Ability>) {
                val Bundle = bundleOf("ability" to ability)
//                val RoleBundle = bundleOf("sbility" to role)
//                setFragmentResult("requestKey", bundleOf("bundleKey" to ability))
                findNavController().navigate(R.id.action_nav_gallery_to_detailAgentFragment,Bundle)
            }

        })
        binding?.recyclerview?.adapter = adapter
        binding?.recyclerview?.layoutManager = GridLayoutManager(requireContext(),1)
        viewModel.agentInfo.observe(viewLifecycleOwner){
            adapter.data = it
        }
    }
}