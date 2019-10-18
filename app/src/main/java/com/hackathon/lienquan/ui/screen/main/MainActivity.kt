package com.hackathon.lienquan.ui.screen.main

import android.os.Bundle
import com.hackathon.lienquan.R
import com.hackathon.lienquan.databinding.ActivityMainBinding
import com.hackathon.lienquan.ui.base.BaseActivity
import com.hackathon.lienquan.ui.screen.home.HomeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModel()
    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addFragment(fragment = HomeFragment.newInstance(), TAG = HomeFragment.TAG)
    }
}
