package com.example.project.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB: ViewBinding,VM: ViewModel>
    (private val inflate: Inflate<VB>, viewModel: Class<VM> ): Fragment() {

    var binding: VB? = null

    protected val viewModel: VM by lazy {
        ViewModelProvider(this).get(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null){
            binding = inflate.invoke(inflater,container,false)
        }
        init(inflater,container)
        return binding?.root
    }
    abstract fun init(inflater: LayoutInflater, viewGroup: ViewGroup?)

}