package com.hackathon.lienquan.ui.screen.search

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import com.hackathon.lienquan.R
import com.hackathon.lienquan.databinding.ActivitySearchBinding
import com.hackathon.lienquan.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : BaseActivity<ActivitySearchBinding, SearchViewModel>(),
    View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_clear_search -> text_search.setText("")
        }
    }

    override val viewModel: SearchViewModel by viewModel()
    override val layoutId = R.layout.activity_search

    override fun onStart() {
        super.onStart()
        registerEvents()
        handleData()
    }

    private fun registerEvents() {
        button_clear_search.setOnClickListener(this)
    }

    private fun handleData() {
        val adapter = SearchAdapter(itemClickListener = {})
        viewModel.searchProductList.observe(this, Observer {
            adapter.submitList(it)
        })
        recycler_product.adapter = adapter
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, SearchActivity::class.java)
    }
}