package com.hackathon.lienquan.ui.screen.main

import com.hackathon.lienquan.R
import com.hackathon.lienquan.databinding.ActivityMainBinding
import com.hackathon.lienquan.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModel()
    override val layoutId: Int = R.layout.activity_main


}
