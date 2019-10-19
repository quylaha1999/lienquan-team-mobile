package com.hackathon.lienquan.ui.screen.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.hackathon.lienquan.R
import com.hackathon.lienquan.data.Category
import com.hackathon.lienquan.databinding.FragmentHomeBinding
import com.hackathon.lienquan.ui.base.BaseFragment
import com.hackathon.lienquan.ui.screen.products.ProductsFragment
import com.hackathon.lienquan.ui.screen.search.SearchActivity
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.image_search -> startActivity(context?.let { SearchActivity.getIntent(it) })
        }
    }

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }

    override val viewModel: HomeViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getCategories()
        registerEvents()
        handleData()
    }

    fun registerEvents() {
        image_search.setOnClickListener(this)
    }

    fun handleData() {
        val adapter = HomeAdapter(itemClickListener = { toProductActivity(it) })
        viewModel.categories.observe(this, Observer {
            adapter.submitList(it)
            progress_loading.visibility = View.GONE
        })
        recycler_category.adapter = adapter
    }

    fun toProductActivity(category: Category) {
        replaceFragment(ProductsFragment.newInstance(category), ProductsFragment.TAG, true)
    }
}