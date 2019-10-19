package com.hackathon.lienquan.ui.screen.home

import android.os.Bundle
import com.hackathon.lienquan.R
import com.hackathon.lienquan.databinding.FragmentHomeBinding
import com.hackathon.lienquan.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }

    override val viewModel: HomeViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getCategories()
    }
}