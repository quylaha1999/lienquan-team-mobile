package com.hackathon.lienquan.ui.screen.search

import android.content.Context
import android.content.Intent
import com.hackathon.lienquan.R
import com.hackathon.lienquan.databinding.ActivitySearchBinding
import com.hackathon.lienquan.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : BaseActivity<ActivitySearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModel()
    override val layoutId = R.layout.activity_search

    override fun onStart() {
        super.onStart()
        addFragmentInSearch(SearchFragment.newInstance(), SearchFragment.TAG)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, SearchActivity::class.java)
    }
}